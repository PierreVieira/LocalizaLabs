package com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders.option

import android.content.Context
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.LinearLayoutCompat
import com.example.mymovieslist.R
import com.example.mymovieslist.data.model.clickable.ClickableMoreItem
import com.example.mymovieslist.data.model.MoreItem
import com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders.base.MoreBaseViewHolder

abstract class OptionViewHolder(itemView: View, context: Context) :
    MoreBaseViewHolder(itemView, context) {

    private val itemTitle: AppCompatTextView = itemView.findViewById(R.id.option_item_title)
    protected val itemSubTitle: AppCompatTextView =
        itemView.findViewById(R.id.option_item_sub_title)
    private val itemImage: AppCompatImageView = itemView.findViewById(R.id.option_image)
    private val itemCell: LinearLayoutCompat = itemView.findViewById(R.id.option_item_container)

    override fun bindItem(moreItem: MoreItem) {
        moreItem as ClickableMoreItem
        itemTitle.text = getString(moreItem.titleId)
        itemSubTitle.text = getString(moreItem.subTitleId)
        itemImage.setImageResource(moreItem.imageResourceId)
        itemCell.setOnClickListener { clickItem(moreItem) }
    }
}