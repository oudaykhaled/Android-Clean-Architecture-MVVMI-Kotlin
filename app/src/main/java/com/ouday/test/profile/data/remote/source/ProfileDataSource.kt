package com.ouday.test.profile.data.remote.source

import com.ouday.test.profile.data.model.Profile

interface ProfileDataSource {
    suspend fun requestLogin(username: String, password: String):Profile
}