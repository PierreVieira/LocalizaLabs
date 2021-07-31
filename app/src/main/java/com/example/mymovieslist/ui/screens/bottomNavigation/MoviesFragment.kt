package com.example.mymovieslist.ui.screens.bottomNavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymovieslist.R
import com.example.mymovieslist.data.MySharedPreferences
import com.example.mymovieslist.enums.FragmentNavigationType

class MoviesFragment : BaseNavigationFragment(FragmentNavigationType.MOVIES) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

}