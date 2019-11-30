package com.ouday.test.customer.data.remote.source

import com.ouday.test.customer.data.model.Customer

interface CustomerRemoteDataSource {
    suspend fun requestAllCustomers(): List<Customer>
}