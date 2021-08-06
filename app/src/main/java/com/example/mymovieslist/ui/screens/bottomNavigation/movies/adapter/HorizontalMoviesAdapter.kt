package com.example.mymovieslist.ui.screens.bottomNavigation.movies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovieslist.R
import com.example.mymovieslist.data.model.api.MovieItem
import com.example.mymovieslist.data.model.screens.movies.HorizontalListItem
import com.example.mymovieslist.enums.HomeItemType
import com.example.mymovieslist.ui.screens.bottomNavigation.BaseViewHolder

class HorizontalMoviesAdapter(
    private val listData: List<HorizontalListItem>,
    private val context: Context,
    private val getMoviesCallback: (homeItemType: HomeItemType, callback: (movies: List<MovieItem>) -> Unit) -> Unit
) :
    RecyclerView.Adapter<HorizontalMoviesAdapter.HorizontalListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = HorizontalListViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.movie_list, parent, false),
        context
    )

    override fun onBindViewHolder(holder: HorizontalListViewHolder, position: Int) {
        val item = listData[position]
        holder.title.text = holder.getString(item.title)
        getMoviesCallback.invoke(item.homeItemType) { movies: List<MovieItem> ->
            holder.recyclerView.adapter = ListMoviesAdapter(movies, context)
        }
    }

    override fun getItemCount() = listData.size

    inner class HorizontalListViewHolder(itemView: View, context: Context) :
        BaseViewHolder(itemView, context) {
        val title: TextView = itemView.findViewById(R.id.title)
        val recyclerView: RecyclerView = itemView.findViewById(R.id.recycler_view)
    }
}