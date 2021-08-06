package com.example.mymovieslist.data.model.screens.movieDetail

import androidx.annotation.StringRes
import com.example.mymovieslist.enums.MovieDetailsItemType

abstract class MovieDetailCard(@StringRes val title: Int, val description: String) : MovieDetailItem(
    MovieDetailsItemType.GENRES)