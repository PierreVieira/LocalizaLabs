package com.example.mymovieslist.data.moreData

import com.example.mymovieslist.R
import com.example.mymovieslist.data.moreData.model.MenuIconsItem
import com.example.mymovieslist.data.moreData.model.MoreItemSocial
import com.example.mymovieslist.data.moreData.model.ThemeItem
import com.example.mymovieslist.enums.MenuOptionType
import com.example.mymovieslist.enums.MoreItemType
import com.example.mymovieslist.enums.ThemeType

object MoreData {
    fun getData(themeType: ThemeType, menuOption: MenuOptionType) = listOf(
        ThemeItem(themeType),
        MenuIconsItem(menuOption),
        MoreItemSocial(
            imageResourceId = R.drawable.ic_github,
            titleId = R.string.github,
            subTitleId = R.string.my_github_user,
            type = MoreItemType.GITHUB,
            socialMediaLink = R.string.my_github_link
        ),
        MoreItemSocial(
            imageResourceId = R.drawable.ic_linkedin,
            titleId = R.string.linkedin,
            subTitleId = R.string.my_linkedin_user,
            type = MoreItemType.LINKEDIN,
            socialMediaLink = R.string.my_linkedin_link
        ),
        MoreItemSocial(
            imageResourceId = R.drawable.ic_youtube,
            titleId = R.string.youtube,
            subTitleId = R.string.my_youtube_use,
            type = MoreItemType.YOUTUBE,
            socialMediaLink = R.string.my_youtube_link
        ),
        MoreItemSocial(
            imageResourceId = R.drawable.ic_instagram,
            titleId = R.string.instagram,
            subTitleId = R.string.my_instagram_user,
            type = MoreItemType.INSTAGRAM,
            socialMediaLink = R.string.my_instagram_link
        ),
        MoreItemSocial(
            imageResourceId = R.drawable.ic_facebook,
            titleId = R.string.facebook,
            subTitleId = R.string.my_facebook_user,
            type = MoreItemType.FACEBOOK,
            socialMediaLink = R.string.my_facebook_link
        )
    )
}