package com.ouday.test.customer.presentation.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ouday.test.core.network.Result
import com.ouday.test.customer.data.model.Customer
import com.ouday.test.customer.domain.CustomerUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CustomerViewModel  @Inject constructor(private val useCase: CustomerUseCase) : ViewModel() {

    private val allCustomersLiveData = MediatorLiveData<Result<List<Customer>>>()
    private var selectedCustomer: Customer? = null

    fun requestAllCustomers() {
        viewModelScope.launch {
            allCustomersLiveData.addSource(useCase.requestAllCustomers()) {
                allCustomersLiveData.value = it
            }
        }
    }

    fun getAllCustomers(): MediatorLiveData<Result<List<Customer>>> {
        return allCustomersLiveData
    }

    fun setSelectedCustomer(selectedCustomer: Customer): CustomerViewModel {
        this.selectedCustomer = selectedCustomer
        return this
    }

    fun getSelectedCustomer(): Customer? {
        return this.selectedCustomer
    }

    fun saveCustomerData(customer: Customer){

    }

}