package com.example.mymovieslist.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.mymovieslist.R
import com.example.mymovieslist.data.MySharedPreferences
import com.example.mymovieslist.databinding.ActivityMainBinding
import com.example.mymovieslist.enums.ThemeType


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigation()
        MySharedPreferences.initializeSharedPreferences(this)
        setTheme(MySharedPreferences.getLastTheme())
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController)
    }

    fun setTheme(themeType: ThemeType) {
        viewModel.changeTheme(themeType)
    }

}