package com.tongsr.kotlindemo.data.http

import com.tongsr.kotlindemo.ui.GirlBean
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/24
 *     desc   :
 * </pre>
 */
interface InterfaceApis {

    companion object {
        val HOST: String
            get() = "https://gank.io/api/"
    }

    /**
     * 妹纸列表
     * @param num 每页的数量
     * @param page 页数
     */
    @GET("data/福利/{num}/{page}")
    fun fetchGirlList(@Path("num") num: Int, @Path("page") page: Int)
            : Flowable<GankHttpResponse<List<GirlBean>>>


}