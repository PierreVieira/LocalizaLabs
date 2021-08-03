package com.example.mymovieslist.ui.screens.bottomNavigation.more

import androidx.lifecycle.ViewModel
import com.example.mymovieslist.data.MySharedPreferences
import com.example.mymovieslist.data.model.MoreItem
import com.example.mymovieslist.data.model.clickable.settings.MenuIconsItem
import com.example.mymovieslist.data.model.clickable.settings.ThemeItem
import com.example.mymovieslist.data.model.clickable.social.*
import com.example.mymovieslist.data.model.simpleText.SubtitleMoreItem
import com.example.mymovieslist.data.model.simpleText.TitleMoreItem
import com.example.mymovieslist.enums.MenuOptionType
import com.example.mymovieslist.enums.ThemeType

class MoreViewModel : ViewModel() {
    val dataList: List<MoreItem>
        get() = getData(getCurrentTheme(), MenuOptionType.ALWAYS_SHOW)

    fun saveCurrentTheme(themeType: ThemeType) {
        MySharedPreferences.saveLastTheme(themeType)
    }

    fun getCurrentTheme() = MySharedPreferences.getLastTheme()

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