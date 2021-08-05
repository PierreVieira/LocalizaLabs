package com.example.mymovieslist.ui.screens.bottomNavigation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymovieslist.R
import com.example.mymovieslist.enums.FragmentNavigationType
import com.example.mymovieslist.ui.screens.bottomNavigation.BaseNavigationFragment

class HomeFragment : BaseNavigationFragment(FragmentNavigationType.HOME) {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}