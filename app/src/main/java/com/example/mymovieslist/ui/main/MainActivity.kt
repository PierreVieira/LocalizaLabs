package com.example.mymovieslist.ui.main

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.mymovieslist.R
import com.example.mymovieslist.data.MySharedPreferences
import com.example.mymovieslist.databinding.ActivityMainBinding
import com.example.mymovieslist.enums.FragmentNavigationType
import com.example.mymovieslist.enums.ThemeType


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private var navGraph: NavGraph? = null
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAppPreferences()
    }

    private fun setupAppPreferences() {
        MySharedPreferences.initializeSharedPreferences(this)
        setupNavigation()
        setTheme(MySharedPreferences.getLastTheme())
    }

    private fun setupNavigation() {
        if (navController == null) {
            navController =
                (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController
            NavigationUI.setupWithNavController(binding.bottomNavigation, navController!!)
            navGraph = navController!!.navInflater.inflate(R.navigation.nav_graph)
            setStartNavigation()
        }
    }

    private fun setStartNavigation() {
        when (MySharedPreferences.getFirstFragment()) {
            FragmentNavigationType.HOME -> setStartDestination(R.id.home_screen)
            FragmentNavigationType.MOVIES -> setStartDestination(R.id.movies_screen)
            FragmentNavigationType.SEARCH -> setStartDestination(R.id.search_screen)
            FragmentNavigationType.TOP_PEOPLES -> setStartDestination(R.id.top_peoples_screen)
            FragmentNavigationType.MORE -> setStartDestination(R.id.more_screen)
        }
        navController?.graph = navGraph!!
    }

    private fun setStartDestination(id: Int) {
        navGraph?.startDestination = id
    }

    fun setTheme(themeType: ThemeType) {
        viewModel.changeTheme(themeType)
    }

}