package com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders.option

import android.content.Context
import android.view.View
import com.example.mymovieslist.R
import com.example.mymovieslist.enums.MoreItemType
import com.example.mymovieslist.data.model.screens.more.MoreItem
import com.example.mymovieslist.data.model.screens.more.clickable.settings.MenuIconsItem
import com.example.mymovieslist.data.model.screens.more.clickable.settings.ThemeItem
import com.example.mymovieslist.enums.MenuOptionType
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
        itemSubTitle.text = getCurrentSubtitleText(moreItem)
    }

    private fun getCurrentSubtitleText(moreItem: MoreItem) = if (moreItem is ThemeItem) {
        mapCurrentThemeToString(moreItem)
    } else {
        moreItem as MenuIconsItem
        mapCurrentMenuOptionToString(moreItem)
    }

    private fun mapCurrentThemeToString(moreItem: ThemeItem) = when (moreItem.currentTheme) {
        ThemeType.SYSTEM -> getString(R.string.theme_system_subtitle)
        ThemeType.LIGHT -> getString(R.string.light)
        ThemeType.DARK -> getString(R.string.dark)
    }

    private fun mapCurrentMenuOptionToString(moreItem: MenuIconsItem) =
        when (moreItem.currentMenuOptionType) {
            MenuOptionType.ALWAYS_SHOW -> getString(R.string.always_show_menu_icons_description_list)
            MenuOptionType.SHOW_ONLY_SELECTED -> getString(R.string.show_only_selected_menu_icons_description_list)
            MenuOptionType.NEVER_SHOW -> getString(R.string.never_show_menu_icons_description)
        }
}