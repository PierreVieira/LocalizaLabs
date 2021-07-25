package com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders

import android.content.Context
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import com.example.mymovieslist.R
import com.example.mymovieslist.model.MoreItem

abstract class OptionViewHolder(itemView: View, context: Context) : MoreBaseViewHolder(itemView, context) {
    private val itemTitle = itemView.findViewById<AppCompatTextView>(R.id.option_item_title)
    private val itemSubTitle = itemView.findViewById<AppCompatTextView>(R.id.option_item_sub_title)
    private val itemImage = itemView.findViewById<AppCompatImageView>(R.id.option_image)
    private val itemCell = itemView.findViewById<LinearLayoutCompat>(R.id.option_item_container)
    override fun bindItem(moreItem: MoreItem) {
        itemTitle.text = getString(moreItem.titleId)
        itemSubTitle.text = getString(moreItem.subTitleId)
        itemImage.setImageResource(moreItem.imageResourceId)
        itemCell.setOnClickListener { clickItem(moreItem) }
    }
}