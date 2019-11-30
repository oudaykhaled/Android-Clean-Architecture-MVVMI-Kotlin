package com.ouday.test.profile.domain

import androidx.lifecycle.LiveData
import com.ouday.test.profile.data.model.Profile
import com.ouday.test.core.network.Result

interface ProfileUseCase {

    suspend fun requestLogin(username: String, password: String): LiveData<Result<Profile>>

}