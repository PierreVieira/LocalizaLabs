package com.example.mymovieslist.ui.screens.details.viewHolders.base

import com.example.mymovieslist.data.model.screens.movieDetail.MovieDetailItem

interface InterfaceDetailsViewHolder {
    fun bindItem(movieDetailItem: MovieDetailItem)
}