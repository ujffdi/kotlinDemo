package com.tongsr.kotlindemo.util

import com.tongsr.kotlindemo.data.http.GankHttpResponse
import com.tongsr.kotlindemo.data.http.exception.ApiException
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/25
 *     desc   : rx util
 * </pre>
 */
class RxUtil {

    companion object {

        fun <T> rxSchedulerHelper(): FlowableTransformer<T, T> {
            return FlowableTransformer {
                it.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
            }
        }

        fun <T> handleResult(): FlowableTransformer<GankHttpResponse<T>, T> {
            return FlowableTransformer {
                it.flatMap { response ->
                    when(response.error) {
                        false -> createData(response.results)
                        true -> Flowable.error(ApiException("服务器返回error"))
                    }
                }
            }
        }

        /**
         * 生成Flowable
         * @param <T> data
         * @return flowable
         */
        fun <T> createData(t: T): Flowable<T> = Flowable.create({
            try {
                it.onNext(t)
                it.onComplete()
            } catch (e: Exception) {
                it.onError(e)
            }
        }, BackpressureStrategy.BUFFER)
    }
}