package com.ouday.test.customer.data.local

import com.ouday.test.customer.data.model.Customer

interface CustomerLocalDataSource {

    suspend fun requestAllCustomers(): List<Customer>
    suspend fun saveAllCustomers(customers: Array<Customer>)
    suspend fun saveCustomer(customer: Customer)

}