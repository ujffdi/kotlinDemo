package com.tongsr.kotlindemo.data.http

import com.tongsr.kotlindemo.ui.GirlBean
import io.reactivex.Flowable
import retrofit2.http.GET

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/24
 *     desc   :
 * </pre>
 */
interface HttpHelper {

    /**
     * 妹纸列表
     * @param num 每页的数量
     * @param page 页数
     */
    @GET("data/福利/{num}/{page}")
    fun fetchGirlList(num: Int, page: Int): Flowable<GankHttpResponse<List<GirlBean>>>
}