package com.example.mymovieslist.data.moreData.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.mymovieslist.enums.MoreItemType

class MoreItemSocial(
    @DrawableRes imageResourceId: Int,
    @StringRes titleId: Int,
    @StringRes subTitleId: Int,
    @StringRes val socialMediaLink: Int,
    type: MoreItemType
) : MoreItem(imageResourceId, titleId, subTitleId, type)