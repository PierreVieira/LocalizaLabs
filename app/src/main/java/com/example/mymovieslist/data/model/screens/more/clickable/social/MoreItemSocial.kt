package com.example.mymovieslist.data.model.screens.more.clickable.social

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.mymovieslist.data.model.screens.more.clickable.ClickableMoreItem
import com.example.mymovieslist.enums.MoreItemType

abstract class MoreItemSocial(
    @DrawableRes imageResourceId: Int,
    @StringRes titleId: Int,
    @StringRes subTitleId: Int,
    @StringRes val socialMediaLink: Int,
    type: MoreItemType
) : ClickableMoreItem(imageResourceId, titleId, subTitleId, type)