package com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovieslist.R
import com.example.mymovieslist.enums.MoreItemType
import com.example.mymovieslist.data.moreData.model.MoreItem
import com.example.mymovieslist.ui.screens.bottomNavigation.more.SettingsListener
import com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders.MoreBaseViewHolder
import com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders.SettingViewHolder
import com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders.SocialViewHolder

class MoreAdapter(
    private val context: Context,
    private val listItems: List<MoreItem>,
    private val settingsListener: SettingsListener,
) :
    RecyclerView.Adapter<MoreBaseViewHolder>() {

    enum class TypeItems {
        LOGIN,
        SETTINGS,
        SOCIAL,
        SUBTITLE;

        companion object {
            fun getEnumFromPosition(position: Int): TypeItems {
                if (position >= 0 && position < values().size) {
                    return values()[position]
                } else {
                    throw IllegalStateException("Invalid listItem position : $position")
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoreBaseViewHolder {
        val itemView: View
        val inflater = LayoutInflater.from(parent.context)
        return when (TypeItems.getEnumFromPosition(viewType)) {
            TypeItems.SETTINGS -> {
                itemView = inflater.inflate(R.layout.option_item_more_setting, parent, false)
                SettingViewHolder(itemView, context, settingsListener)
            }
            TypeItems.SOCIAL -> {
                itemView = inflater.inflate(R.layout.option_item_more_social, parent, false)
                SocialViewHolder(itemView, context)
            }
            TypeItems.LOGIN -> {
                // TODO
                throw IllegalArgumentException("Login not implemented yet.")
            }
            TypeItems.SUBTITLE -> {
                // TODO
                throw IllegalArgumentException("Subtitle not implemented yet.")
            }
        }
    }

    override fun onBindViewHolder(holder: MoreBaseViewHolder, position: Int) {
        val item = listItems[position]
        holder.bindItem(item)
    }

    override fun getItemCount() = listItems.size

    override fun getItemViewType(position: Int) = when (listItems[position].type) {
        MoreItemType.GITHUB -> TypeItems.SOCIAL.ordinal
        MoreItemType.LINKEDIN -> TypeItems.SOCIAL.ordinal
        MoreItemType.INSTAGRAM -> TypeItems.SOCIAL.ordinal
        MoreItemType.FACEBOOK -> TypeItems.SOCIAL.ordinal
        MoreItemType.YOUTUBE -> TypeItems.SOCIAL.ordinal
        MoreItemType.LINE_SOCIAL_MEDIA -> TypeItems.SUBTITLE.ordinal
        MoreItemType.LOGIN -> TypeItems.LOGIN.ordinal
        MoreItemType.MENU -> TypeItems.SETTINGS.ordinal
        MoreItemType.THEME -> TypeItems.SETTINGS.ordinal
    }

    fun updateChangeThemeLabel() {
        notifyItemChanged(1)
    }
}
