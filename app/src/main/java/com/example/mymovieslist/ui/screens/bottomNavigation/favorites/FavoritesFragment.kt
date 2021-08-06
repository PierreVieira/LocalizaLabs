package com.example.mymovieslist.ui.screens.bottomNavigation.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymovieslist.R
import com.example.mymovieslist.enums.FragmentNavigationType
import com.example.mymovieslist.ui.screens.bottomNavigation.BaseNavigationFragment


class FavoritesFragment : BaseNavigationFragment(FragmentNavigationType.FAVORITES) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

}