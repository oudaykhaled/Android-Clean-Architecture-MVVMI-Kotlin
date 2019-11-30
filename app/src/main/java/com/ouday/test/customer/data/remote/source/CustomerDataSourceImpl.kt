package com.ouday.test.customer.data.remote.source

import com.ouday.test.core.di.qualifier.CoroutinesIO
import com.ouday.test.customer.data.remote.services.CustomerService
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class CustomerDataSourceImpl @Inject constructor(
    private val service: CustomerService,
    @CoroutinesIO private val context: CoroutineContext
) : CustomerDataSource {

    override suspend fun requestAllCustomers() = withContext(context){
        val response = service.getAllCustomersAsync().await()
        if (response.isSuccessful)
            response.body() ?: throw Exception("No Response")
        else{
            throw Exception()
        }
    }

}