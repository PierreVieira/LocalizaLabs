package com.example.mymovieslist.ui.screens.bottomNavigation.more

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mymovieslist.data.MySharedPreferences
import com.example.mymovieslist.data.model.screens.more.MoreItem
import com.example.mymovieslist.data.model.screens.more.clickable.settings.MenuIconsItem
import com.example.mymovieslist.data.model.screens.more.clickable.settings.ThemeItem
import com.example.mymovieslist.data.model.screens.more.clickable.social.*
import com.example.mymovieslist.data.model.screens.more.simpleText.SubtitleMoreItem
import com.example.mymovieslist.data.model.screens.more.simpleText.TitleMoreItem
import com.example.mymovieslist.enums.MenuOptionType
import com.example.mymovieslist.enums.ThemeType

class MoreViewModel : ViewModel() {
    val dataList: List<MoreItem>
        get() = getData(getCurrentTheme(), getCurrentMenuOption())

    val currentMenuOption : MutableLiveData<MenuOptionType> by lazy {
        MutableLiveData<MenuOptionType>()
    }

    fun saveCurrentTheme(themeType: ThemeType) {
        MySharedPreferences.saveLastTheme(themeType)
    }

    fun getCurrentTheme() = MySharedPreferences.getLastTheme()
    private fun getCurrentMenuOption() = MySharedPreferences.getLastMenuVisibilityMode()

    private fun getData(themeType: ThemeType, menuOption: MenuOptionType) = listOf(
        TitleMoreItem(),
        ThemeItem(themeType),
        MenuIconsItem(menuOption),
        SubtitleMoreItem(),
        GithubItem(),
        LinkedinItem(),
        YoutubeItem(),
        InstagramItem(),
        FacebookItem()
    )
}