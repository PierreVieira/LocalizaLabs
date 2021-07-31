package com.example.mymovieslist.ui.screens.bottomNavigation

import androidx.fragment.app.Fragment
import com.example.mymovieslist.data.MySharedPreferences
import com.example.mymovieslist.enums.FragmentNavigationType

abstract class BaseNavigationFragment(private val type: FragmentNavigationType) : Fragment() {
    override fun onPause() {
        MySharedPreferences.saveFirstFragment(type)
        super.onPause()
    }
}