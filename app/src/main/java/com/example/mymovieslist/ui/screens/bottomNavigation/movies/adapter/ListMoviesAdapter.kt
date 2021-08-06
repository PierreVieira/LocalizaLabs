package com.example.mymovieslist.ui.screens.bottomNavigation.movies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovieslist.R
import com.example.mymovieslist.data.model.api.MovieItem

class ListMoviesAdapter(
    private val listMovies: List<MovieItem>,
    private val context: Context
) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false),
        context
    )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movieItem = listMovies[position]
        holder.bindMovie(movieItem)
    }

    override fun getItemCount() = listMovies.size

}