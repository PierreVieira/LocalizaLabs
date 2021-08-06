package com.example.mymovieslist.ui.screens.details

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.mymovieslist.R
import com.example.mymovieslist.data.model.api.MovieDetailsItemResponse
import com.example.mymovieslist.data.model.screens.movieDetail.MovieDetailItem
import com.example.mymovieslist.service.MyApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailsViewModel : ViewModel() {
    fun getMovieDetails(
        id: Int,
        context: Context,
        callback: (List<MovieDetailItem>) -> Unit
    ) {
        val myApi = MyApi.getInstance()
        val retrofitData = myApi.getDetails(id)
        retrofitData.enqueue(createCall(context, callback))
    }

    private fun createCall(context: Context, callback: (List<MovieDetailItem>) -> Unit) =
        object : Callback<MovieDetailsItemResponse> {
            override fun onResponse(
                call: Call<MovieDetailsItemResponse>,
                response: Response<MovieDetailsItemResponse>
            ) {
                val responseBody = response.body()
                val moviesList = emptyList<MovieDetailItem>()

                return callback(moviesList)
            }

            override fun onFailure(call: Call<MovieDetailsItemResponse>, t: Throwable) {
                Toast.makeText(context, R.string.cant_load, Toast.LENGTH_LONG).show()
            }
        }
}