package com.ouday.test.customer.di

import com.ouday.test.customer.data.remote.services.CustomerService
import com.ouday.test.customer.data.remote.source.CustomerDataSource
import com.ouday.test.customer.data.remote.source.CustomerDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [CustomerRemoteModule.Binders::class])
class CustomerRemoteModule {

    @Module
    interface Binders {
        @Binds
        fun bindsRemoteSource(
            remoteDataSourceImpl: CustomerDataSourceImpl
        ): CustomerDataSource
    }

    @Provides
    fun providesCustomerService(retrofit: Retrofit): CustomerService =
        retrofit.create(CustomerService::class.java)

}