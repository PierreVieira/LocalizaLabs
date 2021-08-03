package com.example.mymovieslist.data.model.simpleText

import androidx.annotation.StringRes
import com.example.mymovieslist.data.model.MoreItem
import com.example.mymovieslist.enums.MoreItemType

abstract class SimpleTextMoreItemBase(@StringRes titleId: Int, type: MoreItemType) :
    MoreItem(titleId, type)