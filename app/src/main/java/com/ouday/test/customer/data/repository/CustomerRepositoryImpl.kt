package com.ouday.test.customer.data.repository

import androidx.lifecycle.liveData
import com.ouday.test.core.network.Result
import com.ouday.test.customer.data.remote.source.CustomerDataSource
import javax.inject.Inject

class CustomerRepositoryImpl @Inject constructor(private val remoteDataSource: CustomerDataSource) :
    CustomerRepository {

    override suspend fun requestAllCustomers() = liveData {
        emit(Result.loading())
        try {
            val response = remoteDataSource.requestAllCustomers()
            emit(Result.success(response))

        } catch (exception: Exception) {
            emit(Result.error(exception.message ?: ""))
        }
    }

}