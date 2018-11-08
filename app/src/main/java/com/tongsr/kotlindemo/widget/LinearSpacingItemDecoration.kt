package com.tongsr.kotlindemo.widget

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/25
 *     desc   : linear方向间距相等
 * </pre>
 */
class LinearSpacingItemDecoration constructor(private val spacing: Int)
    : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView
                                , state: RecyclerView.State) {
        outRect.left = spacing
        outRect.right = spacing
        outRect.bottom = spacing
        // Add top margin only for the first item to avoid double space between items
        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.top = spacing
        } else {
            outRect.top = 0
        }
    }

}