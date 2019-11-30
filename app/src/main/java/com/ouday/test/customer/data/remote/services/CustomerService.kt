package com.ouday.test.customer.data.remote.services

import com.ouday.test.customer.data.model.Customer
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface CustomerService {

    @GET("https://customers.free.beeceptor.com/customers${CustomerEndPoints.all}")
    fun getAllCustomersAsync(): Deferred<Response<List<Customer>>>

}