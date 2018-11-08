package com.tongsr.kotlindemo.base.api

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/24
 *     desc   : 父类方法
 * </pre>
 */
interface IBaseView {

    /**
     * 绑定布局
     *
     * @return 布局 Id
     */
    @android.support.annotation.LayoutRes fun onBindLayout(): Int

    /**
     * 业务操作()
     */
    fun doBusiness()
}