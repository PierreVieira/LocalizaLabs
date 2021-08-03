package com.example.mymovieslist.data

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.example.mymovieslist.enums.FragmentNavigationType
import com.example.mymovieslist.enums.MenuOptionType
import com.example.mymovieslist.enums.ThemeType
import com.example.mymovieslist.utils.Mapper
import com.google.android.material.navigation.NavigationBarView
import java.lang.IllegalStateException

object MySharedPreferences {
    private const val THEME_KEY = "themeKey"
    private const val MENU_CONFIG_KEY = "menuConfigKey"
    private const val FRAGMENT_NAVIGATION_KEY = "fragmentNavigationKey"
    private var sharedPreferences: SharedPreferences? = null

    fun initializeSharedPreferences(activity: Activity) {
        if (sharedPreferences == null) {
            sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE)
        }
    }

    fun saveLastTheme(themeType: ThemeType) {
        savePreferenceString(THEME_KEY, themeType.name)
    }

    fun saveFirstFragment(fragmentNavigationType: FragmentNavigationType) {
        savePreferenceString(FRAGMENT_NAVIGATION_KEY, fragmentNavigationType.name)
    }

    private fun savePreferenceString(key: String, value: String) {
        sharedPreferences?.let {
            with(it.edit()) {
                putString(key, value).apply()
            }
        } ?: throw IllegalStateException("Shared preferences is null on savePreferenceString")
    }

    private fun safeGetPreference(action: (sharedPreferences: SharedPreferences) -> Any) =
        sharedPreferences?.let {
            action.invoke(it)
        } ?: throw IllegalStateException("Shared preferences is null when read property")

    fun getLastTheme() = safeGetPreference {
        Mapper.mapThemeNameToThemeType(
            it.getString(THEME_KEY, ThemeType.SYSTEM.name)
        )
    } as ThemeType

    fun getFirstFragment() = safeGetPreference {
        Mapper.mapFragmentNavigationNameToFragmentNavigationType(
            it.getString(
                FRAGMENT_NAVIGATION_KEY, FragmentNavigationType.HOME.name
            )
        )
    } as FragmentNavigationType

    fun getLastMenuVisibilityMode() = safeGetPreference {
        Mapper.mapMenuConfigCodeToMenuConfigType(
            it.getInt(
                MENU_CONFIG_KEY,
                NavigationBarView.LABEL_VISIBILITY_LABELED
            )
        )
    } as MenuOptionType
}