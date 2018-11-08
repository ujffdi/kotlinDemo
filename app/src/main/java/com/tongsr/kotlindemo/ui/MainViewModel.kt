package com.tongsr.kotlindemo.ui

import com.tongsr.kotlindemo.base.BaseViewModel
import com.tongsr.kotlindemo.util.RxUtil
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/24
 *     desc   : MainViewModel
 * </pre>
 */
class MainViewModel @Inject constructor(private val mMainRepository: MainRepository) : BaseViewModel() {

    var data: Flowable<List<GirlBean>>? = null

    fun fetchGirlList(num: Int, page: Int): Flowable<List<GirlBean>> {
        if (data == null) {
            data = mMainRepository.fetchGirlList(num, page)
                    .compose(RxUtil.rxSchedulerHelper())
                    .compose(RxUtil.handleResult())
        }
        return data!!
    }
}