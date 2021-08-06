package com.example.mymovieslist.utils

import com.example.mymovieslist.R
import com.example.mymovieslist.enums.FragmentNavigationType
import com.example.mymovieslist.enums.MenuOptionType
import com.example.mymovieslist.enums.ThemeType
import com.google.android.material.navigation.NavigationBarView

object Mapper {
    fun mapFragmentNavigationNameToFragmentNavigationType(fragmentNavigationName: String?) =
        when (fragmentNavigationName) {
            FragmentNavigationType.MOVIES.name -> FragmentNavigationType.MOVIES
            FragmentNavigationType.FAVORITES.name -> FragmentNavigationType.FAVORITES
            else -> FragmentNavigationType.MORE
        }

    fun mapMenuConfigCodeToMenuConfigType(menuConfigCode: Int) = when (menuConfigCode) {
        NavigationBarView.LABEL_VISIBILITY_LABELED -> MenuOptionType.ALWAYS_SHOW
        NavigationBarView.LABEL_VISIBILITY_SELECTED -> MenuOptionType.SHOW_ONLY_SELECTED
        else -> MenuOptionType.NEVER_SHOW
    }

    fun mapThemeNameToThemeType(themeName: String?) = when (themeName) {
        ThemeType.SYSTEM.name -> ThemeType.SYSTEM
        ThemeType.DARK.name -> ThemeType.DARK
        else -> ThemeType.LIGHT
    }

    fun mapFragmentNavigationTypeToStartDestination(
        fragmentTypeNavigation: FragmentNavigationType,
        setStartDestination: (Int) -> Unit
    ) {
        when (fragmentTypeNavigation) {
            FragmentNavigationType.MOVIES -> setStartDestination(R.id.movies_screen)
            FragmentNavigationType.FAVORITES -> setStartDestination(R.id.favorites_screen)
            FragmentNavigationType.MORE -> setStartDestination(R.id.more_screen)
        }
    }

    fun mapMenuOptionTypeToNavigationLabel(lastMenuVisibilityMode: MenuOptionType) =
        when (lastMenuVisibilityMode) {
            MenuOptionType.ALWAYS_SHOW -> NavigationBarView.LABEL_VISIBILITY_LABELED
            MenuOptionType.SHOW_ONLY_SELECTED -> NavigationBarView.LABEL_VISIBILITY_SELECTED
            else -> NavigationBarView.LABEL_VISIBILITY_UNLABELED
        }

}