package com.tongsr.kotlindemo.component.picture

import android.content.Context
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/24
 *     desc   : 生成GlideApp、还可以做一些自定义配置
 * </pre>
 */
@GlideModule
class AppGlideModuleImpl : AppGlideModule() {

    override fun isManifestParsingEnabled(): Boolean {
        return super.isManifestParsingEnabled()
    }

    override fun applyOptions(context: Context, builder: GlideBuilder) {
        super.applyOptions(context, builder)
    }
}