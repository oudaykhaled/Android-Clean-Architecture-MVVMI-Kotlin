package com.ouday.test.customer.presentation.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.ouday.test.R
import com.ouday.test.core.network.Status
import com.ouday.test.core.presentation.BaseFragment
import com.ouday.test.core.presentation.ViewModelFactory
import com.ouday.test.customer.data.model.Customer
import com.ouday.test.customer.presentation.viewmodel.CustomerViewModel
import kotlinx.android.synthetic.main.fragment_customer_detail.*
import javax.inject.Inject

class CustomerDetailFragment : BaseFragment() {


    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: CustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_customer_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.run {
            viewModel =
                ViewModelProviders.of(activity!!, viewModelFactory).get(CustomerViewModel::class.java)
        }

        viewModel.getSelectedCustomer()?.let { initView(it) }

        viewModel.getCustomerSavedObserver().observe(this@CustomerDetailFragment, androidx.lifecycle.Observer {
            when (it.status) {
                Status.LOADING -> showLoading()
                Status.ERROR -> {
                    it.message
                    dismissLoading()
                }
                Status.SUCCESS -> {
                    dismissLoading()
                    Navigation.findNavController(view).popBackStack()
                }
            }
        })

        btnSave.setOnClickListener {
            viewModel.getSelectedCustomer()?.firstName = etFirstName.text.toString()
            viewModel.getSelectedCustomer()?.lastName = etLastName.text.toString()
            viewModel.getSelectedCustomer()?.mobileNumber = etMobileNumber.text.toString()
            viewModel.getSelectedCustomer()?.address = etAddress.text.toString()
            viewModel.getSelectedCustomer()?.let { it1 -> viewModel.saveCustomerData(it1) }
        }

    }

    private fun initView(customer: Customer) {
        etFirstName.setText(customer.firstName)
        etLastName.setText(customer.lastName)
        etMobileNumber.setText(customer.mobileNumber)
        etAddress.setText(customer.address)
    }

}
