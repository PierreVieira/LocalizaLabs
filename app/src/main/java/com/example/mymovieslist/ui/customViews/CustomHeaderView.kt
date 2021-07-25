package com.example.mymovieslist.ui.customViews

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.widget.AbsListView
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovieslist.R

class CustomHeaderView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    companion object {
        private const val ANIMATOR_TIME = 300L
    }

    var shadow: View
    var cardViewContainer: FrameLayout
    var listOnTop = true
    val customScrollListener: CustomScrollListener = CustomScrollListener(
        object : CustomScrollListener.ScrollListener {
            override fun onScrollChanged(onTop: Boolean) {
                setShadowState(onTop)
            }
        }
    )

    init {
        inflate(context, R.layout.custom_header_view, this)
        setBackgroundColor(ContextCompat.getColor(context, R.color.transparent))
        bringToFront()
        shadow = findViewById(R.id.shadow)
        shadow.visibility = View.INVISIBLE
        cardViewContainer = findViewById(R.id.header_view_container)
    }

    fun setView(view: View) {
        cardViewContainer.addView(view)
    }

    fun setShadowState(onTop: Boolean) {
        if (onTop && !listOnTop) {
            listOnTop = true
            shadow.visibility = View.INVISIBLE
        } else if (!onTop && listOnTop) {
            listOnTop = false
            shadow.clearAnimation()
            shadow.alpha = 0f
            shadow.visibility = View.VISIBLE
            shadow.animate()
                .alpha(1f)
                .setInterpolator(AccelerateInterpolator())
                .duration = ANIMATOR_TIME
        }
    }

    class CustomScrollListener(private val scrollListener: ScrollListener) : AbsListView.OnScrollListener, RecyclerView.OnScrollListener() {

        interface ScrollListener {
            fun onScrollChanged(onTop: Boolean)
        }

        override fun onScroll(list: AbsListView?, p1: Int, p2: Int, p3: Int) {
            list?.let {
                if (it.getChildAt(0) != null) {
                    val scrollOnTop = it.firstVisiblePosition == 0 && it.getChildAt(0).top >= 0
                    scrollListener.onScrollChanged(scrollOnTop)
                }
            }
        }

        override fun onScrollStateChanged(p0: AbsListView?, p1: Int) {
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            recyclerView.let {
                val mLayoutManager = recyclerView.layoutManager as LinearLayoutManager
                scrollListener.onScrollChanged(mLayoutManager.findFirstCompletelyVisibleItemPosition() == 0)
            }
        }
    }
}