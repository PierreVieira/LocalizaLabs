package com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders

import android.content.Context
import android.content.res.Configuration
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import com.example.mymovieslist.enums.MoreItemType
import com.example.mymovieslist.model.MoreItem
import com.example.mymovieslist.ui.dialog.ChangeColorThemeDialog
import com.example.mymovieslist.ui.screens.bottomNavigation.more.SettingsListener

class SettingViewHolder(
    itemView: View,
    context: Context,
    private val settingsListener: SettingsListener
) : OptionViewHolder(itemView, context) {

    override fun clickItem(moreItem: MoreItem) {
        if (moreItem.type == MoreItemType.THEME) {
            settingsListener.showChangeThemeDialog()
        }
    }
}