package com.example.mymovieslist.data.model.api

import com.google.gson.annotations.SerializedName

data class MovieItem(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("vote_average")
    val score: Float,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("overview")
    val synopsis: String
)
