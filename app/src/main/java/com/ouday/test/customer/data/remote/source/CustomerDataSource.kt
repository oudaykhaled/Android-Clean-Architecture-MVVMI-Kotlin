package com.ouday.test.customer.data.remote.source

import com.ouday.test.customer.data.model.Customer

interface CustomerDataSource {
    suspend fun requestAllCustomers(): List<Customer>
}