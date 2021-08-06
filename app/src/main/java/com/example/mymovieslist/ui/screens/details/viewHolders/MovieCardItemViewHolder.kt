package com.example.mymovieslist.ui.screens.details.viewHolders

import android.content.Context
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.example.mymovieslist.R
import com.example.mymovieslist.data.model.screens.movieDetail.MovieDetailCard
import com.example.mymovieslist.data.model.screens.movieDetail.MovieDetailItem
import com.example.mymovieslist.ui.screens.details.viewHolders.base.DetailsViewHolder

class MovieCardItemViewHolder(itemView: View, context: Context) :
    DetailsViewHolder(itemView, context) {

    private val title: AppCompatTextView = itemView.findViewById(R.id.title)
    private val description: AppCompatTextView = itemView.findViewById(R.id.description)

    override fun bindItem(movieDetailItem: MovieDetailItem) {
        movieDetailItem as MovieDetailCard
        title.text = getString(movieDetailItem.title)
        description.text = movieDetailItem.description
    }

}