package com.example.mymovieslist.ui.main

import android.app.Application
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mymovieslist.data.MySharedPreferences
import com.example.mymovieslist.enums.MenuOptionType
import com.example.mymovieslist.enums.ThemeType
import com.example.mymovieslist.utils.Mapper
import com.google.android.material.navigation.NavigationBarView

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

    fun helpToStartNavigation(setStartDestination: (Int) -> Unit) {
        Mapper.mapFragmentNavigationTypeToStartDestination(
            MySharedPreferences.getFirstFragment()
        ) { id: Int -> setStartDestination(id) }
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

    fun saveLastVisibilityMode(labelVisibilityMode: Int) {
        MySharedPreferences.saveLastVisibilityMode(labelVisibilityMode)
    }

}