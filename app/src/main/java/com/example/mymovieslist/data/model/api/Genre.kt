package com.example.mymovieslist.data.model.api

import com.google.gson.annotations.SerializedName

data class Genre (
    @SerializedName("name")
    val name: String?,
)