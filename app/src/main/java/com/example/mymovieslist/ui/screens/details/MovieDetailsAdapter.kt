package com.example.mymovieslist.ui.screens.details

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovieslist.R
import com.example.mymovieslist.data.model.screens.movieDetail.MovieDetailItem
import com.example.mymovieslist.enums.MoreItemType
import com.example.mymovieslist.enums.MovieDetailsItemType
import com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.MoreAdapter
import com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders.base.MoreViewHolder
import com.example.mymovieslist.ui.screens.details.viewHolders.MovieCardItemViewHolder
import com.example.mymovieslist.ui.screens.details.viewHolders.MovieTitleItemViewHolder
import com.example.mymovieslist.ui.screens.details.viewHolders.MovieVideoItemViewHolder
import com.example.mymovieslist.ui.screens.details.viewHolders.base.DetailsViewHolder

class MovieDetailsAdapter(
    private val context: Context,
    private val listDetails: List<MovieDetailItem>
) : RecyclerView.Adapter<DetailsViewHolder>() {

    enum class TypeItems {
        VIDEO,
        MOVIE_TITLE,
        CARD;

        companion object {
            fun getEnumFromPosition(position: Int): TypeItems {
                if (position >= 0 && position < MoreAdapter.TypeItems.values().size) {
                    return values()[position]
                } else {
                    throw IllegalArgumentException("Invalid listItem position : $position")
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val itemView: View
        val inflater = LayoutInflater.from(parent.context)
        return when ((TypeItems.getEnumFromPosition(viewType))) {
            TypeItems.VIDEO -> {
                itemView = inflate(inflater, R.layout.video_item, parent)
                MovieVideoItemViewHolder(itemView, context)
            }
            TypeItems.MOVIE_TITLE -> {
                itemView = inflate(inflater, R.layout.movie_title_item, parent)
                MovieTitleItemViewHolder(itemView, context)
            }
            TypeItems.CARD -> {
                itemView = inflate(inflater, R.layout.movie_details_card_info, parent)
                MovieCardItemViewHolder(itemView, context)
            }
        }
    }

    private fun inflate(layoutInflater: LayoutInflater, @LayoutRes layout: Int, parent: ViewGroup) =
        layoutInflater.inflate(layout, parent, false)

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        val item = listDetails[position]
        holder.bindItem(item)
    }

    override fun getItemViewType(position: Int) = when (listDetails[position].type) {
        MovieDetailsItemType.IMAGE -> TypeItems.VIDEO.ordinal
        MovieDetailsItemType.TITLE -> TypeItems.MOVIE_TITLE.ordinal
        MovieDetailsItemType.SYNOPSIS -> TypeItems.MOVIE_TITLE.ordinal
        MovieDetailsItemType.GENRES -> TypeItems.MOVIE_TITLE.ordinal
    }

    override fun getItemCount() = listDetails.size
}