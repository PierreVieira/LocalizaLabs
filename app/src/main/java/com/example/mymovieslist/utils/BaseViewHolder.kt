package com.example.mymovieslist.utils

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(itemView: View, context: Context) :
    RecyclerView.ViewHolder(itemView) {
    private val resources = context.resources
    fun getString(id: Int): String = resources.getString(id)
}