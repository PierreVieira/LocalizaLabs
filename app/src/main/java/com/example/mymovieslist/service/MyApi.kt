package com.example.mymovieslist.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyApi {
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    const val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
    private var instance: ApiInterface? = null
    fun getInstance(): ApiInterface {
        if (instance == null) {
            instance = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(ApiInterface::class.java)
        }
        return instance!!
    }
}