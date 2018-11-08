package com.tongsr.kotlindemo.di.module

import com.tongsr.kotlindemo.data.DataManager
import com.tongsr.kotlindemo.data.http.HttpHelper
import com.tongsr.kotlindemo.data.http.InterfaceApis
import com.tongsr.kotlindemo.data.http.RetrofitHelper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/24
 *     desc   : 注入公用的类
 * </pre>
 */
@Module(includes = [ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideInterfaceApis(retrofit: Retrofit): InterfaceApis =
            retrofit.create(InterfaceApis::class.java)

    @Singleton
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Singleton
    @Provides
    fun provideHttpHelper(retrofitHelper: RetrofitHelper): HttpHelper = retrofitHelper

    @Singleton
    @Provides
    fun provideDataManager(httpHelper: HttpHelper): DataManager =
            DataManager(httpHelper)
}