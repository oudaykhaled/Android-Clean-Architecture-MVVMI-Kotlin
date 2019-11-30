package com.ouday.test.profile.di

import com.ouday.test.profile.data.remote.services.ProfileService
import com.ouday.test.profile.data.remote.source.ProfileDataSource
import com.ouday.test.profile.data.remote.source.ProfileDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Inject

@Module(includes = [ProfileRemoteModule.Binders::class])
class ProfileRemoteModule {

    @Module
    interface Binders {
        @Binds
        fun bindsRemoteSource(
            remoteDataSourceImpl: ProfileDataSourceImpl): ProfileDataSource
    }

    @Provides
    fun providesProfileService(retrofit: Retrofit): ProfileService =
        retrofit.create(ProfileService::class.java)

}