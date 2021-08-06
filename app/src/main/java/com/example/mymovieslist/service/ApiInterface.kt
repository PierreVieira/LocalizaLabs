package com.example.mymovieslist.service

import com.example.mymovieslist.data.model.api.MovieAppResponse
import com.example.mymovieslist.data.model.api.MovieDetailsItemResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("movie/popular?${QUERY_DEFAULT}")
    fun getPopular(): Call<MovieAppResponse>

    @GET("movie/top_rated?${QUERY_DEFAULT}")
    fun getTrending(): Call<MovieAppResponse>

    @GET("movie/{id}?${QUERY_DEFAULT}")
    fun getDetails(@Path("id") id: Int): Call<MovieDetailsItemResponse>

    companion object {
        private const val API_KEY = "cbb0299cdb34a819bc6fbbcd53ba0ed4"
        const val QUERY_DEFAULT = "api_key=$API_KEY"
    }
}