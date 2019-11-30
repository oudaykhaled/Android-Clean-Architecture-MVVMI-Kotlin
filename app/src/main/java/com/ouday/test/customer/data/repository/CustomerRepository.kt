package com.ouday.test.customer.data.repository

import androidx.lifecycle.LiveData
import com.ouday.test.core.network.Result
import com.ouday.test.customer.data.model.Customer

interface CustomerRepository {
    suspend fun requestAllCustomers(): LiveData<Result<List<Customer>>>
}