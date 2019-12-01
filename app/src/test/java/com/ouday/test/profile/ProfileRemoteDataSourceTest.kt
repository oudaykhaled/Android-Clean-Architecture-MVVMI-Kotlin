package com.ouday.test.profile

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.ouday.test.MainCoroutineRule
import com.ouday.test.profile.data.model.Profile
import com.ouday.test.profile.data.remote.services.ProfileService
import com.ouday.test.profile.data.remote.services.requests.LoginRequest
import com.ouday.test.profile.data.remote.source.ProfileDataSource
import com.ouday.test.profile.data.remote.source.ProfileDataSourceImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

class ProfileRemoteDataSourceTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    lateinit var remoteDataSource: ProfileDataSource

    lateinit var service: ProfileService

    val response = Profile(
        "ouday.khaled@gmail.com",
        "ouday",
        "Ouday.K",
        "khaled"
    )

    @Before
    fun init() {
        service = mock {
            onBlocking {
               loginAsync(
                    LoginRequest(
                        "ouday",
                        "123"
                    )
                )
            } doReturn GlobalScope.async {
                Response.success(response)
            }
        }
        remoteDataSource = ProfileDataSourceImpl(service, mainCoroutineRule.coroutineContext)
    }

    @Test
    fun testLoginReturnSuccessResponse() = runBlocking {
        val result = remoteDataSource.requestLogin("ouday", "123")
        assert(result == response)
    }

}