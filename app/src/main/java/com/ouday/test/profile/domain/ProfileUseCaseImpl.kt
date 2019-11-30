package com.ouday.test.profile.domain

import com.ouday.test.profile.data.repository.ProfileRepository
import javax.inject.Inject

class ProfileUseCaseImpl @Inject constructor(private val profileRepository: ProfileRepository) : ProfileUseCase  {

    override suspend fun requestLogin(
        username: String,
        password: String
    ) = profileRepository.requestLogin(username, password)

}