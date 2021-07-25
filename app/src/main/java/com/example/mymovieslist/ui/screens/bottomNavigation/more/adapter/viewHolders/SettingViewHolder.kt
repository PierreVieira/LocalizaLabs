package com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders

import android.content.Context
import android.content.res.Configuration
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import com.example.mymovieslist.enums.MoreItemType
import com.example.mymovieslist.model.MoreItem

class SettingViewHolder(itemView: View, val context: Context) : OptionViewHolder(itemView, context) {
    override fun clickItem(moreItem: MoreItem) {
        if (moreItem.type == MoreItemType.THEME) {
            changeTheme()
        }
    }

    private fun changeTheme() {
        when (context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_YES -> setThemeColors(AppCompatDelegate.MODE_NIGHT_NO)
            Configuration.UI_MODE_NIGHT_NO -> setThemeColors(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }

    private fun setThemeColors(mode: Int) = AppCompatDelegate.setDefaultNightMode(mode)

}