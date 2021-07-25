package com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovieslist.model.MoreItem

abstract class MoreBaseViewHolder(itemView: View, context: Context) :
    RecyclerView.ViewHolder(itemView) {
    private val resources = context.resources
    abstract fun bindItem(moreItem: MoreItem)
    abstract fun clickItem(moreItem: MoreItem)
    protected fun getString(id: Int): String = resources.getString(id)
}