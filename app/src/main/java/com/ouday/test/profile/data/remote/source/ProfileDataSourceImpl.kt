package com.ouday.test.profile.data.remote.source

import com.ouday.test.profile.data.remote.services.ProfileService
import com.ouday.test.core.di.qualifier.CoroutinesIO
import com.ouday.test.profile.data.remote.services.requests.LoginRequest
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class ProfileDataSourceImpl @Inject constructor(
    private val service: ProfileService,
    @CoroutinesIO private val context: CoroutineContext ) : ProfileDataSource{

    override suspend fun requestLogin(username: String, password: String) = withContext(context){
        val response = service.loginAsync(LoginRequest(username, password)).await()
        if (response.isSuccessful)
            response.body() ?: throw Exception("No Response")
        else{
            throw Exception()
        }
    }

}