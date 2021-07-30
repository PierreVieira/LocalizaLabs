package com.example.mymovieslist.data.moreData.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.mymovieslist.enums.MoreItemType

abstract class MoreItem(
    @DrawableRes val imageResourceId: Int,
    @StringRes val titleId: Int,
    @StringRes val subTitleId: Int,
    val type: MoreItemType
)