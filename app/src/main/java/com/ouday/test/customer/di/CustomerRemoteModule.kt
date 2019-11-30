package com.ouday.test.customer.di

import com.ouday.test.customer.data.local.CustomerLocalDataSource
import com.ouday.test.customer.data.local.CustomerLocalDataSourceImpl
import com.ouday.test.customer.data.remote.services.CustomerService
import com.ouday.test.customer.data.remote.source.CustomerRemoteDataSource
import com.ouday.test.customer.data.remote.source.CustomerRemoteDataSourceImpl
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
            remoteDataSourceImpl: CustomerRemoteDataSourceImpl
        ): CustomerRemoteDataSource

        @Binds
        fun bindsLocalSource(
            localDataSourceImpl: CustomerLocalDataSourceImpl
        ): CustomerLocalDataSource
    }

    @Provides
    fun providesCustomerService(retrofit: Retrofit): CustomerService =
        retrofit.create(CustomerService::class.java)


}