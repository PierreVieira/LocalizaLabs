package com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders.base

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class MoreBaseViewHolder(itemView: View, context: Context) :
    RecyclerView.ViewHolder(itemView), InterfaceMoreViewHolder {
    private val resources = context.resources
    protected fun getString(id: Int): String = resources.getString(id)
}