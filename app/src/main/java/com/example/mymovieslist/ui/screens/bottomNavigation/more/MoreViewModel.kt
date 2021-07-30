package com.example.mymovieslist.ui.screens.bottomNavigation.more

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.mymovieslist.R
import com.example.mymovieslist.data.moreData.MoreData
import com.example.mymovieslist.data.MySharedPreferences
import com.example.mymovieslist.data.moreData.model.MoreItem
import com.example.mymovieslist.enums.MenuOptionType
import com.example.mymovieslist.enums.ThemeType

class MoreViewModel(application: Application) : AndroidViewModel(application) {
    val dataList: List<MoreItem>
        get() = MoreData.getData(getCurrentTheme(), MenuOptionType.ALWAYS_SHOW)

    fun saveCurrentTheme(themeType: ThemeType) {
        MySharedPreferences.saveLastTheme(themeType)
    }

    fun getCurrentTheme() = MySharedPreferences.getLastTheme()
    fun mapThemeToString(themeType: ThemeType) =
        when (themeType) {
            ThemeType.SYSTEM -> getString(R.string.theme_system_subtitle)
            ThemeType.LIGHT -> getString(R.string.light)
            ThemeType.DARK -> getString(R.string.dark)
        }

    private fun getString(id: Int) = getApplication<Application>().getString(id)
}