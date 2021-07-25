package com.example.mymovieslist.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.mymovieslist.enums.MoreItemType

open class MoreItem(
    @DrawableRes val imageResourceId: Int,
    @StringRes val titleId: Int,
    @StringRes val subTitleId: Int,
    val type: MoreItemType
) {
}