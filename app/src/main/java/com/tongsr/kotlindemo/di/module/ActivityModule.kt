package com.tongsr.kotlindemo.di.module

import com.tongsr.kotlindemo.ui.GirlActivity
import com.tongsr.kotlindemo.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * 对需要注入的Activity在此添加
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/24
 *     desc   : activity module
 * </pre>
 */
@Suppress("unused")
@Module(includes = [FragmentBuildersModule::class])
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity() : MainActivity

    @ContributesAndroidInjector
    abstract fun contributeGirlActivity() : GirlActivity
}