package com.example.mymovieslist.ui.screens.bottomNavigation.movies.adapter

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.mymovieslist.R
import com.example.mymovieslist.data.model.api.MovieItem
import com.example.mymovieslist.service.MyApi
import com.example.mymovieslist.utils.BaseViewHolder
import com.example.mymovieslist.ui.screens.bottomNavigation.movies.MoviesFragmentDirections

class MovieViewHolder(itemView: View, private val context: Context) :
    BaseViewHolder(itemView, context) {

    companion object {
        private const val NULL_CASE = "?"
    }

    private val image: AppCompatImageView = itemView.findViewById(R.id.movie_image)
    private val score: TextView = itemView.findViewById(R.id.score)
    private val title: TextView = itemView.findViewById(R.id.title)
    private val date: TextView = itemView.findViewById(R.id.date)

    fun bindMovie(movieItem: MovieItem) {
        loadView(movieItem)
        setupClickImage(movieItem)
    }

    private fun loadView(movieItem: MovieItem) {
        title.text = movieItem.title ?: NULL_CASE
        score.text = movieItem.score?.let { getScore(it) } ?: NULL_CASE
        date.text = movieItem.releaseDate?.let { getDate(it) } ?: NULL_CASE
        loadImage(movieItem)
    }

    private fun setupClickImage(movieItem: MovieItem) {
        image.setOnClickListener {
            movieItem.id?.let {
                navigateToMovieDetails(it)
            }
        }
    }

    private fun navigateToMovieDetails(movieId: Int) {
        val action = MoviesFragmentDirections.actionToMovieDetails(id = movieId)
        itemView.findNavController().navigate(action)
    }

    private fun loadImage(movieItem: MovieItem) {
        Glide
            .with(itemView)
            .load(MyApi.IMAGE_BASE + movieItem.posterPath)
            .placeholder(R.drawable.movie_placeholder)
            .into(image)
    }

    private fun getDate(releaseDate: String): String {
        val releaseDateSplit = releaseDate.split('-')
        val year = releaseDateSplit[0]
        val month = getMonthByNumber(releaseDateSplit[1])
        val day = releaseDateSplit[2]
        return context.getString(R.string.movie_date).format(day, month, year)
    }

    private fun getScore(score: Float) = "${(score * 100).toInt()}"

    private fun getMonthByNumber(month: String) = context.getString(
        when (month) {
            "01" -> R.string.january
            "02" -> R.string.february
            "03" -> R.string.march
            "04" -> R.string.april
            "05" -> R.string.may
            "06" -> R.string.june
            "07" -> R.string.july
            "08" -> R.string.august
            "09" -> R.string.september
            "10" -> R.string.october
            "11" -> R.string.november
            else -> R.string.december
        }
    )
}