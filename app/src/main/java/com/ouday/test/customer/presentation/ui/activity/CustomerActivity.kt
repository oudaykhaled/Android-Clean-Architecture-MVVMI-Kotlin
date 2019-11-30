package com.ouday.test.customer.presentation.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.ouday.test.R
import com.ouday.test.core.presentation.BaseActivity
import com.ouday.test.core.presentation.ViewModelFactory
import com.ouday.test.customer.presentation.viewmodel.CustomerViewModel
import javax.inject.Inject

class CustomerActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    companion object{
        fun newInstance(context: Context): Intent {
            return Intent(context, CustomerActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)
    }

}
