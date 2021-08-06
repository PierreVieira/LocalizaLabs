package com.example.mymovieslist.ui.screens.details.viewHolders

import android.content.Context
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import com.bumptech.glide.Glide
import com.example.mymovieslist.R
import com.example.mymovieslist.data.model.screens.movieDetail.MovieDetailImage
import com.example.mymovieslist.data.model.screens.movieDetail.MovieDetailItem
import com.example.mymovieslist.service.MyApi
import com.example.mymovieslist.ui.screens.details.viewHolders.base.DetailsViewHolder

class MovieVideoItemViewHolder(itemView: View, context: Context) :
    DetailsViewHolder(itemView, context) {

    private val imageView: AppCompatImageView = itemView.findViewById(R.id.image)
    private val score: AppCompatTextView = itemView.findViewById(R.id.score)

    override fun bindItem(movieDetailItem: MovieDetailItem) {
        movieDetailItem as MovieDetailImage
        score.text = movieDetailItem.score
        loadImage(movieDetailItem.backgroundPath)
    }

    private fun loadImage(backgroundPath: String) {
        Glide
            .with(itemView)
            .load(MyApi.IMAGE_BASE + backgroundPath)
            .placeholder(R.drawable.movie_placeholder)
            .into(imageView)
    }
}