package com.example.mymovieslist.ui.screens.bottomNavigation.more

import androidx.lifecycle.ViewModel
import com.example.mymovieslist.R
import com.example.mymovieslist.enums.MoreItemType
import com.example.mymovieslist.model.MoreItem
import com.example.mymovieslist.model.MoreItemSocial

class MoreViewModel : ViewModel() {
    val dataList = listOf(
        MoreItem(
            imageResourceId = R.drawable.ic_baseline_nights_stay,
            titleId = R.string.theme,
            subTitleId = R.string.theme_system_subtitle,
            type = MoreItemType.THEME
        ),
        MoreItem(
            imageResourceId = R.drawable.ic_baseline_linear_scale,
            titleId = R.string.simplify_menu_icons_title,
            subTitleId = R.string.default_menu_icons_sub_title,
            type = MoreItemType.MENU
        ),
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