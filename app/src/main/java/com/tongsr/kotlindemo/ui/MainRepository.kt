package com.tongsr.kotlindemo.ui

import com.tongsr.kotlindemo.data.DataManager
import javax.inject.Inject

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/24
 *     desc   : MainRepository
 * </pre>
 */
class MainRepository @Inject constructor(private val mDataManager: DataManager) {


    fun fetchGirlList(num: Int, page: Int) = mDataManager.fetchGirlList(num, page)

}