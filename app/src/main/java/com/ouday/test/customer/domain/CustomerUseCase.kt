package com.ouday.test.customer.domain

import androidx.lifecycle.LiveData
import com.ouday.test.core.network.Result
import com.ouday.test.customer.data.model.Customer

interface CustomerUseCase {

    suspend fun requestAllCustomers(): LiveData<Result<List<Customer>>>

}