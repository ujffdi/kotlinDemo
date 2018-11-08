package com.tongsr.kotlindemo

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.blankj.utilcode.util.Utils
import com.tongsr.kotlindemo.component.GlideLoader
import com.tongsr.kotlindemo.component.picture.ImageLoader
import com.tongsr.kotlindemo.di.AppInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/24
 *     desc   : 程序的入口
 * </pre>
 */
class App: Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
        Utils.init(this)
        ImageLoader.setGlobalImageLoader(GlideLoader())
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}