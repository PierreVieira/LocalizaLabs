package com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovieslist.R
import com.example.mymovieslist.data.model.screens.more.MoreItem
import com.example.mymovieslist.data.model.screens.more.clickable.settings.MenuIconsItem
import com.example.mymovieslist.enums.MenuOptionType
import com.example.mymovieslist.enums.MoreItemType
import com.example.mymovieslist.ui.screens.bottomNavigation.more.SettingsListener
import com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders.base.MoreViewHolder
import com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders.option.SettingViewHolder
import com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders.option.SocialViewHolder
import com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders.simpleText.MoreListSimpleTextViewHolder

class MoreAdapter(
    private val context: Context,
    private val listItems: List<MoreItem>,
    private val settingsListener: SettingsListener,
) : RecyclerView.Adapter<MoreViewHolder>() {

    enum class TypeItems {
        LOGIN,
        SETTINGS,
        SOCIAL,
        SUBTITLE,
        TITLE;

        companion object {
            fun getEnumFromPosition(position: Int): TypeItems {
                if (position >= 0 && position < values().size) {
                    return values()[position]
                } else {
                    throw IllegalArgumentException("Invalid listItem position : $position")
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoreViewHolder {
        val itemView: View
        val inflater = LayoutInflater.from(parent.context)
        return when (TypeItems.getEnumFromPosition(viewType)) {
            TypeItems.LOGIN -> {
                // TODO
                throw IllegalArgumentException("Login not implemented yet.")
            }
            TypeItems.TITLE -> {
                itemView = inflate(inflater, R.layout.more_list_title_item, parent)
                MoreListSimpleTextViewHolder(itemView, context)
            }
            TypeItems.SUBTITLE -> {
                itemView = inflate(inflater, R.layout.more_list_subtitle_item, parent)
                MoreListSimpleTextViewHolder(itemView, context)
            }
            TypeItems.SETTINGS -> {
                itemView = inflate(inflater, R.layout.option_item_more_setting, parent)
                SettingViewHolder(itemView, context, settingsListener)
            }
            TypeItems.SOCIAL -> {
                itemView = inflate(inflater, R.layout.option_item_more_social, parent)
                SocialViewHolder(itemView, context)
            }
        }
    }

    private fun inflate(layoutInflater: LayoutInflater, @LayoutRes layout: Int, parent: ViewGroup) =
        layoutInflater.inflate(layout, parent, false)

    override fun onBindViewHolder(holder: MoreViewHolder, position: Int) {
        val item = listItems[position]
        holder.bindItem(item)
    }

    override fun getItemCount() = listItems.size

    override fun getItemViewType(position: Int) = when (listItems[position].type) {
        MoreItemType.LOGIN -> TypeItems.LOGIN.ordinal
        MoreItemType.TITLE -> TypeItems.TITLE.ordinal
        MoreItemType.THEME -> TypeItems.SETTINGS.ordinal
        MoreItemType.MENU -> TypeItems.SETTINGS.ordinal
        MoreItemType.LINE_SOCIAL_MEDIA -> TypeItems.SUBTITLE.ordinal
        MoreItemType.GITHUB -> TypeItems.SOCIAL.ordinal
        MoreItemType.LINKEDIN -> TypeItems.SOCIAL.ordinal
        MoreItemType.YOUTUBE -> TypeItems.SOCIAL.ordinal
        MoreItemType.INSTAGRAM -> TypeItems.SOCIAL.ordinal
        MoreItemType.FACEBOOK -> TypeItems.SOCIAL.ordinal
    }

    fun setMenuNavigationOptionType(menuOptionType: MenuOptionType) {
        val position = listItems.indexOfFirst { it is MenuIconsItem }
        (listItems[position] as MenuIconsItem).currentMenuOptionType = menuOptionType
        notifyItemChanged(position)
    }

}
