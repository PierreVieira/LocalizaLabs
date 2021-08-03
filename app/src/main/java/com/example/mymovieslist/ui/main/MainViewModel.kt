package com.example.mymovieslist.ui.main

import android.app.Application
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mymovieslist.enums.MenuOptionType
import com.example.mymovieslist.enums.ThemeType
import com.google.android.material.navigation.NavigationBarView

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val currentMenuOption : MutableLiveData<MenuOptionType> by lazy {
        MutableLiveData<MenuOptionType>()
    }

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

    fun mapNavigationLabelToPreferenceMenuOption(lastMenuVisibilityMode: MenuOptionType) =
        when (lastMenuVisibilityMode) {
            MenuOptionType.ALWAYS_SHOW -> NavigationBarView.LABEL_VISIBILITY_LABELED
            MenuOptionType.SHOW_ONLY_SELECTED -> NavigationBarView.LABEL_VISIBILITY_SELECTED
            else -> NavigationBarView.LABEL_VISIBILITY_UNLABELED
        }
}