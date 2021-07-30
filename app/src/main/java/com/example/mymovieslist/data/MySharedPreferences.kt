package com.example.mymovieslist.data

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.example.mymovieslist.enums.ThemeType
import java.lang.IllegalStateException

object MySharedPreferences {
    private const val THEME_KEY = "themeKey"
    private lateinit var sharedPreferences: SharedPreferences

    fun initializeSharedPreferences(activity: Activity) {
        sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE)
    }

    fun saveLastTheme(themeType: ThemeType) {
        with(sharedPreferences.edit()) {
            putString(THEME_KEY, themeType.name)
            apply()
        }
    }

    fun getLastTheme() = when (sharedPreferences.getString(THEME_KEY, ThemeType.SYSTEM.name)) {
        ThemeType.SYSTEM.name -> ThemeType.SYSTEM
        ThemeType.DARK.name -> ThemeType.DARK
        ThemeType.LIGHT.name -> ThemeType.LIGHT
        else -> throw IllegalStateException("Saved theme on shared preference is not valid")
    }
}