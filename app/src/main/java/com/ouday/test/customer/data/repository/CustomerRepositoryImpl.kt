package com.ouday.test.customer.data.repository

import androidx.lifecycle.liveData
import com.ouday.test.core.network.Result
import com.ouday.test.customer.data.local.CustomerLocalDataSource
import com.ouday.test.customer.data.local.CustomerLocalDataSourceImpl
import com.ouday.test.customer.data.remote.source.CustomerRemoteDataSource
import javax.inject.Inject

class CustomerRepositoryImpl @Inject constructor(
    private val remoteDataSource: CustomerRemoteDataSource,
    private val localDataSource: CustomerLocalDataSource) :
    CustomerRepository {

    override suspend fun requestAllCustomers() = liveData {
        emit(Result.loading())
        try {

            var response = localDataSource.requestAllCustomers()

            if (response.isEmpty()){
                response = remoteDataSource.requestAllCustomers()
                localDataSource.saveAllCustomers(response.toTypedArray())
            }

            emit(Result.success(response))

        } catch (exception: Exception) {
            emit(Result.error(exception.message ?: ""))
        }
    }

}