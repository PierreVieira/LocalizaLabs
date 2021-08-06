package com.example.mymovieslist.data.model.api

import com.google.gson.annotations.SerializedName

data class MovieDetailsItemResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("original_title")
    val title: String?,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("vote_average")
    val score: Float?,
    @SerializedName("backdrop_path")
    val image: String?,
    @SerializedName("overview")
    val synopsis: String?
)