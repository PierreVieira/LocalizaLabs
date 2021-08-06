package com.example.mymovieslist.data.model.screens.movies

import androidx.annotation.StringRes
import com.example.mymovieslist.enums.HomeItemType

abstract class HorizontalListItem(@StringRes val title: Int, val homeItemType: HomeItemType)