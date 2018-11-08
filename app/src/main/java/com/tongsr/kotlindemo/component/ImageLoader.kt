package com.tongsr.kotlindemo.component.picture

import android.net.Uri
import com.tongsr.kotlindemo.component.picture.action.ILoaderStrategy
import com.tongsr.kotlindemo.component.picture.dao.LoaderOptions
import java.io.File

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/24
 *     desc   : 策略或者静态代理模式，开发者只需要关心ImageLoader + LoaderOptions
 * </pre>
 */
object ImageLoader {

    private var mLoader: ILoaderStrategy? = null

    /**
     * 提供全局替换图片加载框架的接口，若切换其它框架，可以实现一键全局替换
     */
    fun setGlobalImageLoader(loader: ILoaderStrategy) {
        this.mLoader = loader
    }

    fun load(url: String): LoaderOptions.Builder = LoaderOptions.Builder(url)

    fun load(drawable: Int): LoaderOptions.Builder = LoaderOptions.Builder(drawable)

    fun load(file: File): LoaderOptions.Builder = LoaderOptions.Builder(file)

    fun load(uri: Uri): LoaderOptions.Builder = LoaderOptions.Builder(uri)

    /**
     * 优先使用时设置的图片loader，其次使用全局设置的图片loader
     *
     * @param options options
     */
    fun loadOptions(options: LoaderOptions.Builder) {
        if (options.loader != null) {
            options.loader?.loadImage(options)
        } else {
            checkNotNull()
            mLoader?.loadImage(options)
        }
    }

    /**
     * 清楚内存缓存
     */
    fun clearMemoryCache() {
        checkNotNull()
        mLoader?.clearMemoryCache()
    }

    /**
     * 清楚磁盘缓存
     */
    fun clearDiskCache() {
        //TODO 只能在子线程
        checkNotNull()
        mLoader?.clearDiskCache()
    }

    private fun checkNotNull() {
        if (mLoader == null) {
            throw NullPointerException("you must be set your imageLoader at first!")
        }
    }

}