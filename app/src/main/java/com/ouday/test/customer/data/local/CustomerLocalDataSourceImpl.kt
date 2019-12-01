package com.ouday.test.customer.data.local

import com.ouday.test.core.persistence.DatabaseClient
import com.ouday.test.customer.data.model.Customer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CustomerLocalDataSourceImpl @Inject constructor(): CustomerLocalDataSource {

    override suspend fun saveCustomer(customer: Customer)  = withContext(Dispatchers.IO){
        DatabaseClient.getInstance()
            .appDatabase
            .customerDao()
            .update(customer)
    }

    override suspend fun requestAllCustomers() = withContext(Dispatchers.IO){
        DatabaseClient.getInstance()
            .appDatabase
            .customerDao().getAllCustomers()
    }


    override suspend fun saveAllCustomers(customers: Array<Customer>) = withContext(Dispatchers.IO){
        DatabaseClient.getInstance()
            .appDatabase
            .customerDao().insertAll(customers)
    }

}