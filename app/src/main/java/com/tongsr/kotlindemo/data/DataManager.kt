package com.tongsr.kotlindemo.data

import com.tongsr.kotlindemo.data.http.GankHttpResponse
import com.tongsr.kotlindemo.data.http.HttpHelper
import com.tongsr.kotlindemo.ui.GirlBean
import io.reactivex.Flowable

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/24
 *     desc   : 数据管理类
 * </pre>
 */
class DataManager constructor(private val mHttpHelper: HttpHelper) : HttpHelper {

    override fun fetchGirlList(num: Int, page: Int): Flowable<GankHttpResponse<List<GirlBean>>>
            = mHttpHelper.fetchGirlList(num, page)
}