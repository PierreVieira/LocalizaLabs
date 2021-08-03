package com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders.simpleText

import android.content.Context
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.example.mymovieslist.R
import com.example.mymovieslist.data.model.MoreItem
import com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders.base.MoreBaseViewHolder

class MoreListSimpleTextViewHolder(itemView: View, context: Context) :
    MoreBaseViewHolder(itemView, context) {

    private val subtitle: AppCompatTextView = itemView.findViewById(R.id.text)

    override fun bindItem(moreItem: MoreItem) {
        subtitle.text = getString(moreItem.titleId)
    }

    override fun clickItem(moreItem: MoreItem) {}

}