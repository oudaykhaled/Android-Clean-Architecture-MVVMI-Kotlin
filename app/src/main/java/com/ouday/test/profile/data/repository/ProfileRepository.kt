package com.ouday.test.profile.data.repository

import androidx.lifecycle.LiveData
import com.ouday.test.profile.data.model.Profile
import com.ouday.test.core.network.Result

interface ProfileRepository {
    suspend fun requestLogin(username: String, password: String): LiveData<Result<Profile>>
}