package com.tongsr.kotlindemo.ui

import android.text.TextUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.tongsr.kotlindemo.R
import com.tongsr.kotlindemo.component.picture.ImageLoader

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/26
 *     desc   :
 * </pre>
 */
class MainAdapter : BaseQuickAdapter<GirlBean, BaseViewHolder>(R.layout.item_girl, null) {

    override fun convert(helper: BaseViewHolder, item: GirlBean) {
        if (TextUtils.isEmpty(item.url)) {
            helper.setGone(R.id.iv_girl, false)
        } else {
            ImageLoader.load(item.url)
                    .centerCrop()
                    .skipLocalCache()
                    .into(helper.getView(R.id.iv_girl))
        }

    }
}