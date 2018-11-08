package com.tongsr.kotlindemo.base.activity

import android.app.Activity
import android.os.Bundle
import com.blankj.utilcode.util.ScreenUtils
import com.tongsr.kotlindemo.base.api.IBaseView
import com.tongsr.kotlindemo.util.StatusBarUtil

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/24
 *     desc   : parent activity
 * </pre>
 */
abstract class SimpleActivity : SupportActivity(), IBaseView {

    protected lateinit var mContext: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        //白底黑字
        StatusBarUtil.setDarkMode(this)
        //屏幕适配,以360为基础
        if (!ScreenUtils.isAdaptScreen()) {
            if (ScreenUtils.isPortrait()) {
                ScreenUtils.adaptScreen4VerticalSlide(this, 360)
            } else {
                ScreenUtils.adaptScreen4HorizontalSlide(this, 360)
            }
        }

        val bundle = intent.extras
        bundle?.let {
            onParseIntent(it)
        }

        setContentView(onBindLayout())
        onViewCreated(savedInstanceState)

        doBusiness()
        onHandleObserve()
    }

    /**
     * 自定义生命周期
     */
    protected open fun onViewCreated(savedInstanceState: Bundle?) {

    }

    /**
     * 初始化数据
     *
     * @param bundle 传递过来的 bundle
     */
    protected open fun onParseIntent(bundle: Bundle) {

    }

    /**
     * 处理Observe
     */
    protected open fun onHandleObserve() {

    }
}