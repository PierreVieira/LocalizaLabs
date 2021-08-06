package com.example.mymovieslist.data.model.screens.more.clickable

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.mymovieslist.data.model.screens.more.MoreItem
import com.example.mymovieslist.enums.MoreItemType

abstract class ClickableMoreItem(
    @DrawableRes val imageResourceId: Int,
    @StringRes titleId: Int,
    @StringRes val subTitleId: Int,
    type: MoreItemType
) : MoreItem(titleId, type)