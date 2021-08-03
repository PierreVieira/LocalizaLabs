package com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders.option

import android.content.Context
import android.view.View
import com.example.mymovieslist.R
import com.example.mymovieslist.enums.MoreItemType
import com.example.mymovieslist.data.model.MoreItem
import com.example.mymovieslist.data.model.clickable.settings.ThemeItem
import com.example.mymovieslist.enums.ThemeType
import com.example.mymovieslist.ui.screens.bottomNavigation.more.SettingsListener

class SettingViewHolder(
    itemView: View,
    context: Context,
    private val settingsListener: SettingsListener,
) : OptionViewHolder(itemView, context) {

    override fun clickItem(moreItem: MoreItem) {
        if (moreItem.type == MoreItemType.THEME) {
            settingsListener.showChangeThemeDialog(itemSubTitle)
        } else {
            settingsListener.showChangeMenuConfigsDialog()
        }
    }

    override fun bindItem(moreItem: MoreItem) {
        super.bindItem(moreItem)
        if (moreItem is ThemeItem) {
            itemSubTitle.text = when (moreItem.currentTheme) {
                ThemeType.SYSTEM -> getString(R.string.theme_system_subtitle)
                ThemeType.LIGHT -> getString(R.string.light)
                ThemeType.DARK -> getString(R.string.dark)
            }
        }
    }
}