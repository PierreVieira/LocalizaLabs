package com.example.mymovieslist.data

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.example.mymovieslist.enums.FragmentNavigationType
import com.example.mymovieslist.enums.ThemeType
import java.lang.IllegalStateException

object MySharedPreferences {
    private const val THEME_KEY = "themeKey"
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

    fun getLastTheme() = sharedPreferences?.let {
        when (it.getString(THEME_KEY, ThemeType.SYSTEM.name)) {
            ThemeType.SYSTEM.name -> ThemeType.SYSTEM
            ThemeType.DARK.name -> ThemeType.DARK
            ThemeType.LIGHT.name -> ThemeType.LIGHT
            else -> throw IllegalArgumentException("Saved theme on shared preference is not valid")
        }
    } ?: throw IllegalStateException("Shared preferences is null on getLastTheme")

    fun getFirstFragment() = sharedPreferences?.let {
        when (it.getString(FRAGMENT_NAVIGATION_KEY, FragmentNavigationType.HOME.name)) {
            FragmentNavigationType.HOME.name -> FragmentNavigationType.HOME
            FragmentNavigationType.MOVIES.name -> FragmentNavigationType.MOVIES
            FragmentNavigationType.SEARCH.name -> FragmentNavigationType.SEARCH
            FragmentNavigationType.TOP_PEOPLES.name -> FragmentNavigationType.TOP_PEOPLES
            FragmentNavigationType.MORE.name -> FragmentNavigationType.MORE
            else -> throw IllegalArgumentException("Fragment navigation on shared preference is not valid")
        }
    } ?: throw IllegalStateException("Shared preferences is null on getFirstFragment")
}