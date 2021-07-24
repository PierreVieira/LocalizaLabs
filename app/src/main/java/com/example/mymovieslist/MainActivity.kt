package com.example.mymovieslist

import android.content.res.Configuration
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate


class MainActivity : AppCompatActivity() {

    private lateinit var changeThemeButton: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeThemeButton = findViewById(R.id.change_theme_icon)
        setupChangeImageButton()
    }

    private fun setupChangeImageButton() {
        changeThemeButton.setOnClickListener {
            when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
                Configuration.UI_MODE_NIGHT_YES -> setThemeColors(AppCompatDelegate.MODE_NIGHT_NO)
                Configuration.UI_MODE_NIGHT_NO -> setThemeColors(AppCompatDelegate.MODE_NIGHT_YES)
            }
        }
    }

    private fun setThemeColors(mode: Int) = AppCompatDelegate.setDefaultNightMode(mode)
}