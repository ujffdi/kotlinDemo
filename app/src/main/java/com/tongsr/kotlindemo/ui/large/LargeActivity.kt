package com.tongsr.kotlindemo.ui.large

import android.os.Bundle
import com.tongsr.kotlindemo.Const
import com.tongsr.kotlindemo.R
import com.tongsr.kotlindemo.base.activity.SimpleActivity
import com.tongsr.kotlindemo.component.picture.ImageLoader
import kotlinx.android.synthetic.main.activity_large.*

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/29
 *     desc   : 大图模式
 * </pre>
 */
class LargeActivity : SimpleActivity() {

    private lateinit var mLargeUrl: String

    override fun onBindLayout(): Int = R.layout.activity_large

    override fun onParseIntent(bundle: Bundle) {
        super.onParseIntent(bundle)
        mLargeUrl = bundle.getString(Const.LARGE_URL_FLAG)
    }

    override fun doBusiness() {
        ImageLoader.load(mLargeUrl)
                .centerCrop()
                .skipLocalCache()
                .into(photo)

        photo.setOnClickListener {
            finish()
        }
    }
}