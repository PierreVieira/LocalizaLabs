package com.example.mymovieslist.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.mymovieslist.R
import com.example.mymovieslist.data.MySharedPreferences
import com.example.mymovieslist.databinding.ActivityMainBinding
import com.example.mymovieslist.enums.ThemeType
import com.example.mymovieslist.utils.Mapper


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
            val fragmentManager = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
            navController = (fragmentManager as NavHostFragment).navController
            updateVisibilityIconsOnBottomNavigation(
                Mapper.mapMenuOptionTypeToNavigationLabel(
                    MySharedPreferences.getLastMenuVisibilityMode()
                )
            )
            NavigationUI.setupWithNavController(binding.bottomNavigation, navController!!)
            navGraph = navController!!.navInflater.inflate(R.navigation.navigation_graph)
            setStartNavigation()
        }
    }

    fun updateVisibilityIconsOnBottomNavigation(labelVisibilityMode: Int) {
        binding.bottomNavigation.labelVisibilityMode = labelVisibilityMode
        viewModel.saveLastVisibilityMode(labelVisibilityMode)
    }

    private fun setStartNavigation() {
        viewModel.helpToStartNavigation { id: Int ->
            navGraph?.startDestination = id
        }
        navController?.graph = navGraph!!
    }

    fun setTheme(themeType: ThemeType) {
        viewModel.changeTheme(themeType)
    }

}