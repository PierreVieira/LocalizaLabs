package com.example.mymovieslist.ui.main

import android.app.Application
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.AndroidViewModel
import com.example.mymovieslist.enums.ThemeType

class MainViewModel(application: Application) : AndroidViewModel(application) {

    fun changeTheme(selected: ThemeType) {
        when (selected) {
            ThemeType.DARK -> changeToDarkTheme()
            ThemeType.LIGHT -> changeToLightTheme()
            ThemeType.SYSTEM -> {
                when (getApplication<Application>().resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
                    Configuration.UI_MODE_NIGHT_NO -> changeToLightTheme()
                    Configuration.UI_MODE_NIGHT_YES -> changeToDarkTheme()
                }
            }
        }
    }

    private fun changeToLightTheme() {
        setThemeColors(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun changeToDarkTheme() {
        setThemeColors(AppCompatDelegate.MODE_NIGHT_YES)
    }

    private fun setThemeColors(mode: Int) {
        AppCompatDelegate.setDefaultNightMode(mode)
    }
}