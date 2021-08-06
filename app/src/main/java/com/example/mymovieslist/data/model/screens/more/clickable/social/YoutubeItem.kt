package com.example.mymovieslist.data.model.screens.more.clickable.social

import com.example.mymovieslist.R
import com.example.mymovieslist.enums.MoreItemType

class YoutubeItem : MoreItemSocial(
    imageResourceId = R.drawable.ic_youtube,
    titleId = R.string.youtube,
    subTitleId = R.string.my_youtube_use,
    type = MoreItemType.YOUTUBE,
    socialMediaLink = R.string.my_youtube_link
)