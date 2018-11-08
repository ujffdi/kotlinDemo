package com.tongsr.kotlindemo.base.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tongsr.kotlindemo.base.api.IBaseView

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/24
 *     desc   : parent fragment
 * </pre>
 */
abstract class SimpleFragment : SupportFragment(), IBaseView {

    protected lateinit var mActivity: Activity
    protected lateinit var mContext: Context
    protected var isInit: Boolean = false

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mActivity = context as Activity
        mContext = context
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?
                              , savedInstanceState: Bundle?): View? {
        return inflater.inflate(onBindLayout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        if (bundle != null) {
            onParseIntent(bundle)
        }
    }

    override fun onLazyInitView(savedInstanceState: Bundle?) {
        super.onLazyInitView(savedInstanceState)
        //懒加载
        isInit = true
        doBusiness()
        onHandleObserve()
    }

    /**
     * 初始化数据，在子类里判断Bundle是否为null
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