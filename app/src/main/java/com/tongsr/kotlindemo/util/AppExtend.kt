package com.tongsr.kotlindemo.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.tongsr.kotlindemo.data.http.GankHttpResponse
import com.trello.rxlifecycle2.LifecycleTransformer
import io.reactivex.Flowable

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/19
 *     desc   : 一些扩展函数
 * </pre>
 */

/**
 * 开启一个activity
 * @param bundle bundle
 */
inline fun <reified T : Activity> Context.startActivity(bundle: Bundle?) {
    val intent = Intent(this, T::class.java)
    if (bundle != null) {
        intent.putExtras(bundle)
    }
    startActivity(intent)
}

/**
 * 简化rxJava请求,可以指定某个生命周期或者托管
 * @param lifecycle LifecycleTransformer<T>
 * @return Flowable<T>
 */
fun <T> Flowable<GankHttpResponse<T>>.rxCompose(lifecycle: LifecycleTransformer<T>): Flowable<T> =
        this.compose(RxUtil.rxSchedulerHelper())
                .compose(RxUtil.handleResult())
                .compose(lifecycle)

