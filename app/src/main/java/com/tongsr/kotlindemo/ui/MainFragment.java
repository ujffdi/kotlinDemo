package com.tongsr.kotlindemo.ui;

import android.arch.lifecycle.ViewModelProvider;

import com.tongsr.kotlindemo.R;
import com.tongsr.kotlindemo.base.fragment.SimpleFragment;
import com.tongsr.kotlindemo.di.Injectable;

import javax.inject.Inject;

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/26
 *     desc   :
 * </pre>
 */
public class MainFragment extends SimpleFragment implements Injectable {

    @Inject
    ViewModelProvider.Factory mViewModelProvider;

    @Override
    public int onBindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void doBusiness() {

    }
}
