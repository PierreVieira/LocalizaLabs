package com.example.mymovieslist.ui.screens.bottomNavigation.movies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymovieslist.R
import com.example.mymovieslist.data.model.api.MovieItem
import com.example.mymovieslist.service.MyApi
import com.example.mymovieslist.ui.screens.bottomNavigation.BaseViewHolder

class ListMoviesAdapter(
    private val listMovies: List<MovieItem>,
    private val context: Context
) :
    RecyclerView.Adapter<ListMoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false),
        context
    )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movieItem = listMovies[position]
        holder.bindMovie(movieItem)
    }

    private fun getScore(score: Float) = "${(score * 100).toInt()}"

    override fun getItemCount() = listMovies.size

    inner class MovieViewHolder(itemView: View, context: Context) :
        BaseViewHolder(itemView, context) {

        private val image: AppCompatImageView = itemView.findViewById(R.id.movie_image)
        private val score: TextView = itemView.findViewById(R.id.score)
        private val title: TextView = itemView.findViewById(R.id.title)
        private val date: TextView = itemView.findViewById(R.id.date)

        fun bindMovie(movieItem: MovieItem) {
            title.text = movieItem.title
            score.text = getScore(movieItem.score)
            date.text = getDate(movieItem.releaseDate)
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
}