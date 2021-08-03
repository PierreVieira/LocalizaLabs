package com.example.mymovieslist.data.model.clickable.social

import com.example.mymovieslist.R
import com.example.mymovieslist.enums.MoreItemType

class InstagramItem : MoreItemSocial(
    imageResourceId = R.drawable.ic_instagram,
    titleId = R.string.instagram,
    subTitleId = R.string.my_instagram_user,
    type = MoreItemType.INSTAGRAM,
    socialMediaLink = R.string.my_instagram_link
)