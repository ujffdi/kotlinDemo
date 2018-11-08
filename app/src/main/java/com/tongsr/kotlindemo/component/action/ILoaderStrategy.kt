package com.tongsr.kotlindemo.component.picture.action

import com.tongsr.kotlindemo.component.picture.dao.LoaderOptions

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/24
 *     desc   : 定义公共的方法
 * </pre>
 */
interface ILoaderStrategy {

    /**
     * load image
     * @param options LoaderOptions
     */
    fun loadImage(options: LoaderOptions.Builder)

    /**
     * 清理内存缓存
     */
    fun clearMemoryCache()

    /**
     * 清理磁盘缓存
     */
    fun clearDiskCache()
}