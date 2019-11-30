package com.ouday.test.customer.presentation.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.ouday.test.R
import com.ouday.test.core.presentation.BaseActivity

class CustomerActivity : BaseActivity() {

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
