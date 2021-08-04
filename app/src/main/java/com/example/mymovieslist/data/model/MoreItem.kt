package com.example.mymovieslist.data.model

import androidx.annotation.StringRes
import com.example.mymovieslist.enums.MoreItemType

abstract class MoreItem(@StringRes val titleId: Int, var type: MoreItemType)