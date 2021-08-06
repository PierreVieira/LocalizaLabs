package com.example.mymovieslist.data.model.screens.more.simpleText

import androidx.annotation.StringRes
import com.example.mymovieslist.data.model.screens.more.MoreItem
import com.example.mymovieslist.enums.MoreItemType

abstract class SimpleTextMoreItemBase(@StringRes titleId: Int, type: MoreItemType) :
    MoreItem(titleId, type)