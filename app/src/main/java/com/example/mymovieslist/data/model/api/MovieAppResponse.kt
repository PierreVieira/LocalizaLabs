package com.example.mymovieslist.data.model.api

import com.google.gson.annotations.SerializedName

data class MovieAppResponse(
    @SerializedName("results")
    val movieList: List<MovieItem>
)