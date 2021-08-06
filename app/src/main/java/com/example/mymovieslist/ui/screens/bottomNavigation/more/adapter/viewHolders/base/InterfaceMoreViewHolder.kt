package com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders.base

import com.example.mymovieslist.data.model.screens.more.MoreItem

interface InterfaceMoreViewHolder {
    fun bindItem(moreItem: MoreItem)
    fun clickItem(moreItem: MoreItem)
}