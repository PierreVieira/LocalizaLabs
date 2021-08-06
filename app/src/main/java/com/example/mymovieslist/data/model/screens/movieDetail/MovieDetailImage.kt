package com.example.mymovieslist.data.model.screens.movieDetail

import com.example.mymovieslist.enums.MovieDetailsItemType

class MovieDetailImage(val backgroundPath: String, val score: String) : MovieDetailItem(MovieDetailsItemType.IMAGE)