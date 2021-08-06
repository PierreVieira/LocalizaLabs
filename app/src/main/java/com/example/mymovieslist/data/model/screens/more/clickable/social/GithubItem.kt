package com.example.mymovieslist.data.model.screens.more.clickable.social

import com.example.mymovieslist.R
import com.example.mymovieslist.enums.MoreItemType

class GithubItem : MoreItemSocial(
    imageResourceId = R.drawable.ic_github,
    titleId = R.string.github,
    subTitleId = R.string.my_github_user,
    type = MoreItemType.GITHUB,
    socialMediaLink = R.string.my_github_link
)