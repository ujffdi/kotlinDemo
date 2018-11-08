package com.tongsr.kotlindemo.base.activity

import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator
import me.yokeyword.fragmentation.anim.FragmentAnimator
import javax.inject.Inject

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/26
 *     desc   :
 * </pre>
 */
abstract class BaseActivity : SimpleActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var mDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = mDispatchingAndroidInjector

    override fun onCreateFragmentAnimator(): FragmentAnimator = DefaultHorizontalAnimator()
}