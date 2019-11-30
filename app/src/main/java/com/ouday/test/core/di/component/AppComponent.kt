package com.ouday.test.core.di.component

import android.app.Application
import com.ouday.test.core.App
import com.ouday.test.core.di.modules.ContextModule
import com.ouday.test.core.di.modules.NetworkModule

import com.ouday.test.core.di.builder.ActivityBuilder
import com.ouday.test.core.di.builder.FragmentBuilder
import com.ouday.test.core.di.modules.SchedulersModule
import com.ouday.test.customer.di.CustomerDomainModule
import com.ouday.test.customer.di.CustomerPresentationModule
import com.ouday.test.customer.di.CustomerRemoteModule
import com.ouday.test.profile.di.ProfileDomainModule
import com.ouday.test.profile.di.ProfilePresentationModule
import com.ouday.test.profile.di.ProfileRemoteModule

import com.ouday.test.core.di.modules.CoroutinesThreadsProvider
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        NetworkModule::class, ContextModule::class,
        ActivityBuilder::class,
        FragmentBuilder::class,
        ProfileRemoteModule::class,
        SchedulersModule::class,
        ProfilePresentationModule::class,
        ProfileDomainModule::class,
        CustomerRemoteModule::class,
        CustomerPresentationModule::class,
        CustomerDomainModule::class,
        CoroutinesThreadsProvider::class]
)
interface AppComponent {

    fun inject(app: App)

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}