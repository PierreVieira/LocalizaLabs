package com.example.mymovieslist.data.model.screens.more.clickable.social

import com.example.mymovieslist.R
import com.example.mymovieslist.enums.MoreItemType

class FacebookItem : MoreItemSocial(
    imageResourceId = R.drawable.ic_facebook,
    titleId = R.string.facebook,
    subTitleId = R.string.my_facebook_user,
    type = MoreItemType.FACEBOOK,
    socialMediaLink = R.string.my_facebook_link
)