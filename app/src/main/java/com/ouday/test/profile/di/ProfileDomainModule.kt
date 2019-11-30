package com.ouday.test.profile.di

import com.ouday.test.profile.data.repository.ProfileRepository
import com.ouday.test.profile.data.repository.ProfileRepositoryImpl
import com.ouday.test.profile.domain.ProfileUseCase
import com.ouday.test.profile.domain.ProfileUseCaseImpl
import dagger.Binds
import dagger.Module

@Module
abstract class ProfileDomainModule {

    @Binds
    abstract fun bindProfileUseCase(
        useCaseImpl: ProfileUseCaseImpl
    ): ProfileUseCase

    @Binds
    abstract fun bindRepo(
        repoImpl: ProfileRepositoryImpl
    ): ProfileRepository

}