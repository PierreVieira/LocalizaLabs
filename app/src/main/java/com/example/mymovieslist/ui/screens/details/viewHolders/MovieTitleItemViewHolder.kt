package com.example.mymovieslist.ui.screens.details.viewHolders

import android.content.Context
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.example.mymovieslist.R
import com.example.mymovieslist.data.model.screens.movieDetail.MovieDetailItem
import com.example.mymovieslist.data.model.screens.movieDetail.MovieDetailTitle
import com.example.mymovieslist.ui.screens.details.viewHolders.base.DetailsViewHolder

class MovieTitleItemViewHolder(itemView: View, context: Context) :
    DetailsViewHolder(itemView, context) {

    private val titleTextView: AppCompatTextView = itemView.findViewById(R.id.title)

    override fun bindItem(movieDetailItem: MovieDetailItem) {
        movieDetailItem as MovieDetailTitle
        titleTextView.text = movieDetailItem.title
    }

}