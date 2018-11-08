package com.tongsr.kotlindemo.component

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.widget.ImageView
import com.blankj.utilcode.util.ConvertUtils
import com.blankj.utilcode.util.Utils
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.Request
import com.bumptech.glide.request.target.SizeReadyCallback
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.request.transition.Transition
import com.tongsr.kotlindemo.component.picture.GlideApp
import com.tongsr.kotlindemo.component.picture.action.BitmapCallBack
import com.tongsr.kotlindemo.component.picture.action.ILoaderStrategy
import com.tongsr.kotlindemo.component.picture.dao.LoaderOptions
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/24
 *     desc   : GlideLoader；可进行Glide的自定义
 * </pre>
 */
class GlideLoader : ILoaderStrategy {

    override fun loadImage(options: LoaderOptions.Builder) {
        val glideRequest = when {
            !TextUtils.isEmpty(options.url) -> GlideApp.with(Utils.getApp()).load(options.url)
            options.file != null -> GlideApp.with(Utils.getApp()).load(options.file)
            options.drawableResId != 0 -> GlideApp.with(Utils.getApp()).load(options.drawableResId)
            options.uri != null -> GlideApp.with(Utils.getApp()).load(options.uri)
            else -> throw NullPointerException("requestCreator must not be null")
        }

        if (options.targetWidth > 0 && options.targetHeight > 0) {
            val width = ConvertUtils.dp2px(options.targetWidth.toFloat())
            val height = ConvertUtils.dp2px(options.targetHeight.toFloat())
            glideRequest.override(width, height)
        }
        if (options.isCenterInside) {
            glideRequest.centerInside()
        } else if (options.isCenterCrop) {
            glideRequest.centerCrop()
        }
        if (options.config != null) {

        }
        if (options.errorResId != 0) {
            glideRequest.error(options.errorResId)
        }
        if (options.placeholderResId != 0) {
            glideRequest.placeholder(options.placeholderResId)
        }
        if (options.bitmapAngle != 0F) {
            glideRequest.transform(RoundedCornersTransformation(options.bitmapAngle.toInt()
                    , 0, RoundedCornersTransformation.CornerType.ALL))
        }
        if (options.skipLocalCache) {
            glideRequest.diskCacheStrategy(DiskCacheStrategy.RESOURCE)
        }
        if (options.skipNetCache) {

        }
        if (options.degrees != 0F) {

        }
        when {
            options.callback != null -> {
//                val target = GlideTarget(options.callback!!)
//                val into = glideRequest.into<GlideTarget>(target)
            }
            options.targetView is ImageView -> glideRequest.into(options.targetView as ImageView)
        }
    }

    override fun clearMemoryCache() = GlideApp.get(Utils.getApp()).clearMemory()

    override fun clearDiskCache() {
        //TODO 只能在子线程。并没有做处理
        GlideApp.get(Utils.getApp()).clearDiskCache()
    }

    private class GlideTarget constructor(private var callback: BitmapCallBack) : Target<Bitmap> {

        override fun onLoadStarted(placeholder: Drawable?) {

        }

        override fun onLoadFailed(errorDrawable: Drawable?) =
                callback.onBitmapFailed(Exception("load failed"))

        override fun getSize(cb: SizeReadyCallback) {
        }

        override fun getRequest(): Request? = null

        override fun onStop() {
        }

        override fun setRequest(request: Request?) {
        }

        override fun removeCallback(cb: SizeReadyCallback) {
        }

        override fun onLoadCleared(placeholder: Drawable?) {
        }

        override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) = callback.onBitmapLoaded(resource)

        override fun onStart() {
        }

        override fun onDestroy() {
        }

    }
}