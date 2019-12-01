package com.ouday.test.profile

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ouday.test.LiveDataTestUtil
import com.ouday.test.MainCoroutineRule
import com.ouday.test.core.network.Status
import com.ouday.test.profile.data.model.Profile
import com.ouday.test.profile.data.remote.services.requests.LoginRequest
import com.ouday.test.profile.data.remote.source.ProfileDataSource
import com.ouday.test.profile.data.repository.ProfileRepository
import com.ouday.test.profile.data.repository.ProfileRepositoryImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class ProfileRepositoryTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    lateinit var repository: ProfileRepository

    @Mock
    lateinit var remoteDataSource: ProfileDataSource

    val request = LoginRequest(
        "ouday",
        "123"
    )

    val response = Profile(
        "ouday.khaled@gmail.com",
        "ouday",
        "Ouday.K",
        "khaled"
    )

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        repository = ProfileRepositoryImpl(remoteDataSource)
    }

    @Test
    fun testRequestLoginReturnSuccess() = mainCoroutineRule.runBlockingTest {
        Mockito.`when`(remoteDataSource.requestLogin(request.username, request.password)).thenReturn(response)
        val result = repository.requestLogin(request.username, request.password)
        assert(LiveDataTestUtil.getValue(result).status == Status.LOADING)
        assert(LiveDataTestUtil.getValue(result).status == Status.SUCCESS)
        assert(LiveDataTestUtil.getValue(result).data == response)
    }

}