package com.tongsr.kotlindemo.widget


import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/25
 *     desc   : NpaLinearLayoutManager
 * </pre>
 */
class NpaLinearLayoutManager : LinearLayoutManager {

    constructor(context: Context
                , attrs: AttributeSet
                , defStyleAttr: Int
                , defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
    }

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context
                , orientation: Int
                , reverseLayout: Boolean) : super(context, orientation, reverseLayout) {
    }

    /**
     * Disable predictive animations. There is a bug in RecyclerView which causes views that
     * are being reloaded to pull invalid ViewHolders from the internal recycler stack if the
     * adapter size has decreased since the ViewHolder was recycled.
     */
    override fun supportsPredictiveItemAnimations(): Boolean = false

}