package com.ouday.test.profile.presentation.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ouday.test.profile.data.model.Profile
import com.ouday.test.profile.domain.ProfileUseCase
import kotlinx.coroutines.launch
import com.ouday.test.core.network.Result
import javax.inject.Inject

class ProfileViewModel @Inject constructor(private val useCase: ProfileUseCase) : ViewModel() {

    private val loginLiveData = MediatorLiveData<Result<Profile>>()

    fun requestLogin(username: String, password: String) {
        viewModelScope.launch {
            loginLiveData.addSource(useCase.requestLogin(username, password)) {
                loginLiveData.value = it
            }
        }
    }

    fun getLoginLiveData(): MediatorLiveData<Result<Profile>> {
        return loginLiveData
    }

}