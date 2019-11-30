package com.ouday.test.customer.di

import com.ouday.test.customer.data.repository.CustomerRepository
import com.ouday.test.customer.data.repository.CustomerRepositoryImpl
import com.ouday.test.customer.domain.CustomerUseCase
import com.ouday.test.customer.domain.CustomerUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class CustomerDomainModule {

    @Binds
    abstract fun bindCustomerUseCase(
        useCaseImpl: CustomerUseCaseImpl
    ): CustomerUseCase

    @Binds
    abstract fun bindRepo(
        repoImpl: CustomerRepositoryImpl
    ): CustomerRepository

}