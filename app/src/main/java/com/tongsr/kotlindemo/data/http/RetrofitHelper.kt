package com.tongsr.kotlindemo.data.http

import com.tongsr.kotlindemo.ui.GirlBean
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/24
 *     desc   : RetrofitHelper
 * </pre>
 */
class RetrofitHelper @Inject constructor(private val interfaceApis: InterfaceApis) : HttpHelper {

    override fun fetchGirlList(num: Int, page: Int): Flowable<GankHttpResponse<List<GirlBean>>>
            = interfaceApis.fetchGirlList(num, page)

}