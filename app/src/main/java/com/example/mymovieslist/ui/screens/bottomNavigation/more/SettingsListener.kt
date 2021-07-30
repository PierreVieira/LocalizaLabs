package com.example.mymovieslist.ui.screens.bottomNavigation.more

import androidx.appcompat.widget.AppCompatTextView

interface SettingsListener {
    fun showChangeThemeDialog(changeThemeSubtitleTextView: AppCompatTextView)
    fun showChangeMenuConfigsDialog()
}