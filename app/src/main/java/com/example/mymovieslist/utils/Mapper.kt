package com.example.mymovieslist.utils

import com.example.mymovieslist.data.MySharedPreferences
import com.example.mymovieslist.enums.FragmentNavigationType
import com.example.mymovieslist.enums.MenuOptionType
import com.example.mymovieslist.enums.ThemeType
import com.google.android.material.navigation.NavigationBarView

object Mapper {
    fun mapFragmentNavigationNameToFragmentNavigationType(fragmentNavigationName: String?) =
        when (fragmentNavigationName) {
            FragmentNavigationType.HOME.name -> FragmentNavigationType.HOME
            FragmentNavigationType.MOVIES.name -> FragmentNavigationType.MOVIES
            FragmentNavigationType.SEARCH.name -> FragmentNavigationType.SEARCH
            FragmentNavigationType.TOP_PEOPLES.name -> FragmentNavigationType.TOP_PEOPLES
            else -> FragmentNavigationType.MORE
        }

    fun mapMenuConfigCodeToMenuConfigType(menuConfigCode: Int) = when (menuConfigCode) {
        NavigationBarView.LABEL_VISIBILITY_LABELED -> MenuOptionType.ALWAYS_SHOW
        NavigationBarView.LABEL_VISIBILITY_SELECTED -> MenuOptionType.SHOW_ONLY_SELECTED
        else -> MenuOptionType.ALWAYS_NOT_SHOW
    }

    fun mapThemeNameToThemeType(themeName: String?) = when (themeName) {
        ThemeType.SYSTEM.name -> ThemeType.SYSTEM
        ThemeType.DARK.name -> ThemeType.DARK
        else -> ThemeType.LIGHT
    }

}