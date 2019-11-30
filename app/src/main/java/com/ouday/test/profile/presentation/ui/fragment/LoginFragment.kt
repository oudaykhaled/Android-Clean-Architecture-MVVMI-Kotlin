package com.ouday.test.profile.presentation.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.test.core.app.ApplicationProvider

import com.ouday.test.R
import com.ouday.test.core.network.Status
import com.ouday.test.core.persistence.DatabaseClient
import com.ouday.test.core.presentation.BaseFragment
import com.ouday.test.core.presentation.ViewModelFactory
import com.ouday.test.customer.presentation.ui.activity.CustomerActivity
import com.ouday.test.profile.data.model.Profile
import com.ouday.test.profile.presentation.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(activity!!, viewModelFactory).get(ProfileViewModel::class.java)

        viewModel.getLoginLiveData().observe(this@LoginFragment,androidx.lifecycle.Observer {
            when (it.status) {
                Status.LOADING -> showLoading()
                Status.ERROR -> {
                    it.message
                    dismissLoading()
                }
                Status.SUCCESS -> {
                    dismissLoading()
                    it.data?.let {data ->
                        onLoginSuccess(data)
                    }
                }
            }
        })


        btnLogin.setOnClickListener {
            viewModel.requestLogin(etUsername.text.toString(), etPassword.text.toString())
        }
    }

    private fun onLoginSuccess(data: Profile) {
        startActivity(context?.let { CustomerActivity.newInstance(it) })
    }

}
