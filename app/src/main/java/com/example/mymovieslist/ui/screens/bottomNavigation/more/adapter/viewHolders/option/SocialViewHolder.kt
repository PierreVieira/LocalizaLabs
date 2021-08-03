package com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.viewHolders.option

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Toast
import com.example.mymovieslist.R
import com.example.mymovieslist.data.model.MoreItem
import com.example.mymovieslist.data.model.clickable.social.MoreItemSocial

class SocialViewHolder(itemView: View, private val context: Context) : OptionViewHolder(itemView, context) {
    override fun clickItem(moreItem: MoreItem) {
        val moreItemSocial = moreItem as MoreItemSocial
        openUrl(getString(moreItemSocial.socialMediaLink))
    }

    private fun openUrl(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(String.format(url)))
        try {
            context.startActivity(browserIntent)
        } catch (e: Exception) {
            Toast.makeText(context, getString(R.string.cant_open_link), Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }
}