package com.example.mymovieslist.service

import com.example.mymovieslist.data.model.api.MovieAppResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("movie/popular?${QUERY_DEFAULT}")
    fun getPopular(): Call<MovieAppResponse>

    @GET("movie/top_rated?${QUERY_DEFAULT}")
    fun getTrending(): Call<MovieAppResponse>

    companion object {
        private const val API_KEY = "cbb0299cdb34a819bc6fbbcd53ba0ed4"
        const val QUERY_DEFAULT = "api_key=$API_KEY"
    }
}