package com.tongsr.kotlindemo.component.picture.dao

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.support.annotation.DrawableRes
import android.view.View
import com.tongsr.kotlindemo.component.picture.ImageLoader
import com.tongsr.kotlindemo.component.picture.action.BitmapCallBack
import com.tongsr.kotlindemo.component.picture.action.ILoaderStrategy
import java.io.File


/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/24
 *     desc   : 该类为图片加载框架的通用属性封装，不能耦合任何一方的框架
 * </pre>
 */
class LoaderOptions {

    class Builder constructor() {

        var url: String? = null
        var file: File? = null
        var drawableResId = 0
        var uri: Uri? = null

        constructor(url: String) : this() {
            this.url = url
        }

        constructor(file: File) : this() {
            this.file = file
        }

        constructor(drawableResId: Int) : this() {
            this.drawableResId = drawableResId
        }

        constructor(uri: Uri) : this() {
            this.uri = uri
        }

        /**
         * 加载中图片ID
         */
        var placeholderResId = 0
        /**
         * 加载中图片Drawable
         */
        var placeholder: Drawable? = null
        /**
         * 加载错误图片
         */
        var errorResId = 0
        /**
         * 居中显示
         */
        var isCenterCrop = false
        /**
         * 居中显示
         */
        var isCenterInside = false
        /**
         * 是否缓存到本地
         */
        var skipLocalCache = false
        /**
         * 是否缓存到网络
         */
        var skipNetCache = false
        /**
         * bitmap config
         */
        var config: Bitmap.Config = Bitmap.Config.RGB_565
        /**
         * 目标宽度
         */
        var targetWidth = 0
        /**
         * 目标高度
         */
        var targetHeight = 0
        /**
         * 圆角角度
         */
        var bitmapAngle = 0F
        /**
         * 旋转角度.注意:picasso针对三星等本地图片，默认旋转回0度，即正常位置。此时不需要自己rotate
         */
        var degrees = 0F
        /**
         * 目标View
         */
        var targetView: View? = null
        /**
         * 实时切换图片加载库
         */
        var loader: ILoaderStrategy? = null
        /**
         * bitmap callback
         */
        var callback: BitmapCallBack? = null


        fun placeholder(@DrawableRes placeholderResId: Int): Builder {
            this.placeholderResId = placeholderResId
            return this
        }

        fun placeholder(placeholder: Drawable): Builder {
            this.placeholder = placeholder
            return this
        }

        fun error(@DrawableRes errorResId: Int): Builder {
            this.errorResId = errorResId
            return this
        }

        fun centerCrop(): Builder {
            isCenterCrop = true
            return this
        }

        fun centerInside(): Builder {
            isCenterInside = true
            return this
        }

        fun skipLocalCache(): Builder {
            skipLocalCache = true
            return this
        }

        fun skipNetCache(): Builder {
            skipNetCache = true
            return this
        }

        fun config(config: Bitmap.Config): Builder {
            this.config = config
            return this
        }

        fun resize(targetWidth: Int, targetHeight: Int): Builder {
            this.targetWidth = targetWidth
            this.targetHeight = targetHeight
            return this
        }

        fun angle(bitmapAngle: Float): Builder {
            this.bitmapAngle = bitmapAngle
            return this
        }

        fun rotate(degrees: Float): Builder {
            this.degrees = degrees
            return this
        }

        fun loader(imageLoader: ILoaderStrategy): Builder {
            this.loader = imageLoader
            return this
        }

        fun into(targetView: View) {
            this.targetView = targetView
            ImageLoader.loadOptions(this)
        }

        fun bitmap(callback: BitmapCallBack) {
            this.callback = callback
            ImageLoader.loadOptions(this)
        }


    }


}