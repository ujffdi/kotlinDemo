package com.tongsr.kotlindemo.component.picture.action

import android.graphics.Bitmap

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/24
 *     desc   : BitmapCallBack
 * </pre>
 */
interface BitmapCallBack {

    /**
     * load bitmap
     * @param bitmap bitmap
     */
    fun onBitmapLoaded(bitmap: Bitmap)

    /**
     * load bitmap fail
     * @param e exception
     */
    fun onBitmapFailed(e: Exception)

    class EmptyCallback : BitmapCallBack {


        override fun onBitmapLoaded(bitmap: Bitmap) {

        }

        override fun onBitmapFailed(e: Exception) {

        }
    }
}