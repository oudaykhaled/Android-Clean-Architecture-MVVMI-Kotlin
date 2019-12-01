package com.ouday.test.profile

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.ouday.test.LiveDataTestUtil
import com.ouday.test.MainCoroutineRule
import com.ouday.test.core.network.Result
import com.ouday.test.core.network.Status
import com.ouday.test.profile.data.model.Profile
import com.ouday.test.profile.data.remote.services.requests.LoginRequest
import com.ouday.test.profile.domain.ProfileUseCase
import com.ouday.test.profile.presentation.viewmodel.ProfileViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ProfileViewModelTest {
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    lateinit var profileViewModel: ProfileViewModel

    lateinit var useCase: ProfileUseCase

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
    fun init(){
        useCase = mock ()
    }



    @Test
    fun testRequestLoginWhenStatusIsLoading() = mainCoroutineRule.runBlockingTest {

        useCase = mock {
            onBlocking { requestLogin(request.username, request.password) } doReturn object : LiveData<Result<Profile>>() {
                init {
                    value = Result.loading()
                }
            }
        }
        profileViewModel = ProfileViewModel(useCase)
        profileViewModel.requestLogin(request.username, request.password)

        val result = profileViewModel.getLoginLiveData()
        result.observeForever {}
        assert(LiveDataTestUtil.getValue(result).status == Status.LOADING)

    }


    @Test
    fun testRequestLoginWhenStatusIsSuccess() = mainCoroutineRule.runBlockingTest {

        useCase = mock {
            onBlocking { requestLogin(request.username, request.password) } doReturn object : LiveData<Result<Profile>>() {
                init {
                    value = Result.success(response)
                }
            }
        }
        profileViewModel = ProfileViewModel(useCase)
        profileViewModel.requestLogin(request.username, request.password)
        val result = profileViewModel.getLoginLiveData()
        result.observeForever {}
        kotlinx.coroutines.delay(2000)
        assert(LiveDataTestUtil.getValue(result).status == Status.SUCCESS &&
                LiveDataTestUtil.getValue(result).data == response)

    }


    @Test
    fun testRequestLoginWhenStatusIsFailed() = mainCoroutineRule.runBlockingTest {

        useCase = mock {
            onBlocking { requestLogin(request.username, request.password) } doReturn object : LiveData<Result<Profile>>() {
                init {
                    value = Result.error("error")
                }
            }
        }
        profileViewModel = ProfileViewModel(useCase)
        profileViewModel.requestLogin(request.username, request.password)
        val result = profileViewModel.getLoginLiveData()
        result.observeForever {}
        kotlinx.coroutines.delay(2000)
        assert(LiveDataTestUtil.getValue(result).status == Status.ERROR &&
                LiveDataTestUtil.getValue(result).message == "error")

    }

}