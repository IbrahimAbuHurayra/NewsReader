package com.xubbzz.news.core.presentation.util

import android.content.res.Resources
import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpaceItemDecoration(
    private val space: Int = 0,
    private val orientation: Orientation = Orientation.VERTICAL,

    private val useSpaceForBothSide: Boolean = false
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        when (orientation) {
            Orientation.VERTICAL -> {
                if (useSpaceForBothSide) {
                    outRect.bottom = space / 2
                    outRect.top = space / 2
                } else {
                    outRect.top = if (parent.getChildAdapterPosition(view) > 0) space else 0
                }
            }

            Orientation.HORIZONTAL -> {
                if (useSpaceForBothSide) {
                    outRect.right = space / 2
                    outRect.left = space / 2
                } else {
                    outRect.left = if (parent.getChildAdapterPosition(view) > 0) space else 0
                }
            }
        }
    }

    enum class Orientation { VERTICAL, HORIZONTAL }
}

fun Number.toDp(): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    )
}

fun Number.toDpInt() = toDp().toInt()