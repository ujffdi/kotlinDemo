package com.tongsr.kotlindemo.di.module

import com.tongsr.kotlindemo.ui.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * 对需要注入的Fragment在此添加
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/24
 *     desc   : fragment module
 * </pre>
 */
@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment
}