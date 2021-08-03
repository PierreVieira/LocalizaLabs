package com.example.mymovieslist.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.mymovieslist.R
import com.example.mymovieslist.data.MySharedPreferences
import com.example.mymovieslist.databinding.ActivityMainBinding
import com.example.mymovieslist.enums.FragmentNavigationType
import com.example.mymovieslist.enums.ThemeType
import com.google.android.material.bottomnavigation.BottomNavigationView


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
            val bottomNavigation = getBottomNavigation()
            NavigationUI.setupWithNavController(bottomNavigation, navController!!)
            navGraph = navController!!.navInflater.inflate(R.navigation.nav_graph)
            setStartNavigation()
        }
    }

    private fun getBottomNavigation(): BottomNavigationView {
        val bottomNavigation = binding.bottomNavigation
        bottomNavigation.labelVisibilityMode = viewModel.mapNavigationLabelToPreferenceMenuOption(
            MySharedPreferences.getLastMenuVisibilityMode()
        )
        return bottomNavigation
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