package com.example.mymovieslist.ui.screens.bottomNavigation.movies

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.mymovieslist.R
import com.example.mymovieslist.data.model.api.MovieAppResponse
import com.example.mymovieslist.data.model.api.MovieItem
import com.example.mymovieslist.data.model.screens.movies.MostPopularHorizontalListItem
import com.example.mymovieslist.data.model.screens.movies.TrendingTvHorizontalListItem
import com.example.mymovieslist.enums.HomeItemType
import com.example.mymovieslist.service.MyApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel : ViewModel() {

    val data = listOf(
        MostPopularHorizontalListItem(),
        TrendingTvHorizontalListItem()
    )

    fun getMovieList(
        homeItemType: HomeItemType,
        context: Context,
        callback: (List<MovieItem>) -> Unit
    ) {
        val myApi = MyApi.getInstance()
        val retrofitData = if (homeItemType == HomeItemType.MORE_POPULAR) {
            myApi.getPopular()
        } else {
            myApi.getTrending()
        }
        retrofitData.enqueue(createCall(context, callback))
    }

    private fun createCall(context: Context, callback: (List<MovieItem>) -> Unit) =
        object : Callback<MovieAppResponse> {
            override fun onResponse(
                call: Call<MovieAppResponse>,
                response: Response<MovieAppResponse>
            ) {
                val responseBody = response.body()
                val moviesList = responseBody?.movieList!!
                return callback(moviesList)
            }

            override fun onFailure(call: Call<MovieAppResponse>, t: Throwable) {
                Toast.makeText(context, R.string.cant_load, Toast.LENGTH_LONG).show()
            }
        }
}