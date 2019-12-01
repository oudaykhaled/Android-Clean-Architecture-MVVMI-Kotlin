package com.ouday.test.customer.domain

import com.ouday.test.customer.data.model.Customer
import com.ouday.test.customer.data.repository.CustomerRepository
import javax.inject.Inject

class CustomerUseCaseImpl  @Inject constructor(private val customerRepository: CustomerRepository) :
    CustomerUseCase {

    override suspend fun updateCustomer(customer: Customer)  = customerRepository.updateCustomer(customer)

    override suspend fun requestAllCustomers() = customerRepository.requestAllCustomers()
}