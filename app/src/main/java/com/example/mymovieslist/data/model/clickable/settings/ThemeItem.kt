package com.example.mymovieslist.data.model.clickable.settings

import com.example.mymovieslist.R
import com.example.mymovieslist.data.model.clickable.ClickableMoreItem
import com.example.mymovieslist.enums.MoreItemType
import com.example.mymovieslist.enums.ThemeType

class ThemeItem(
    val currentTheme: ThemeType
) : ClickableMoreItem(
    imageResourceId = R.drawable.ic_baseline_nights_stay,
    titleId = R.string.theme,
    subTitleId = R.string.theme_system_subtitle,
    type = MoreItemType.THEME
)