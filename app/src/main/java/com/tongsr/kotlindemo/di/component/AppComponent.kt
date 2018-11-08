package com.tongsr.kotlindemo.di.component

import android.app.Application
import com.tongsr.kotlindemo.App
import com.tongsr.kotlindemo.data.DataManager
import com.tongsr.kotlindemo.data.http.RetrofitHelper
import com.tongsr.kotlindemo.di.module.ActivityModule
import com.tongsr.kotlindemo.di.module.AppModule
import com.tongsr.kotlindemo.di.module.HttpModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * <pre>
 *     author : Tongsr
 *     time   : 2018/10/24
 *     desc   : 生成dagger代码的桥梁(Component)
 * </pre>
 */
@Singleton
@Component(
        modules = [
            AndroidInjectionModule::class,
            HttpModule::class,
            AppModule::class,
            ActivityModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    /**
     * 依赖注入调用方法，在Application中初始化
     */
    fun inject(app: App)

    /**
     * 对外提供DataManager
     */
    fun getDataManager(): DataManager

    /**
     * 对外提供RetrofitHelper
     */
    fun getRetrofitHelper(): RetrofitHelper
}