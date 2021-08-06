package com.example.mymovieslist.data.model.screens.more.clickable.social

import com.example.mymovieslist.R
import com.example.mymovieslist.enums.MoreItemType

class LinkedinItem : MoreItemSocial(
    imageResourceId = R.drawable.ic_linkedin,
    titleId = R.string.linkedin,
    subTitleId = R.string.my_linkedin_user,
    type = MoreItemType.LINKEDIN,
    socialMediaLink = R.string.my_linkedin_link
)