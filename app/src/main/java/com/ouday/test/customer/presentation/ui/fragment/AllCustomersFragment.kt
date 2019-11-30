package com.ouday.test.customer.presentation.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.ouday.test.R
import com.ouday.test.core.network.Status
import com.ouday.test.core.presentation.BaseFragment
import com.ouday.test.core.presentation.ViewModelFactory
import com.ouday.test.customer.data.model.Customer
import com.ouday.test.customer.presentation.ui.activity.CustomerActivity
import com.ouday.test.customer.presentation.ui.adapter.CustomerRecyclerViewAdapter
import com.ouday.test.customer.presentation.viewmodel.CustomerViewModel
import kotlinx.android.synthetic.main.fragment_all_customers.*
import javax.inject.Inject


class AllCustomersFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: CustomerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_all_customers, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =
            ViewModelProviders.of(activity!!, viewModelFactory).get(CustomerViewModel::class.java)

        viewModel.getAllCustomers().observe(this@AllCustomersFragment, androidx.lifecycle.Observer {
            when (it.status) {
                Status.LOADING -> showLoading()
                Status.ERROR -> {
                    it.message
                    dismissLoading()
                }
                Status.SUCCESS -> {
                    dismissLoading()
                    it.data?.let { data ->
                        drawCustomersList(data)
                    }
                }
            }
        })

        viewModel.requestAllCustomers()

    }

    private fun drawCustomersList(data: List<Customer>) {
        rvCustomers.layoutManager = LinearLayoutManager(context)
        rvCustomers.adapter = CustomerRecyclerViewAdapter(data)
            .setOnCustomerClickListener {
                onCustomerSelected(it)
            }
    }

    private fun onCustomerSelected(selectedCustomer: Customer) {
        viewModel.setSelectedCustomer(selectedCustomer)
        view?.let { Navigation.findNavController(it).navigate(R.id.action_allCustomersFragment_to_customerDetailFragment) }
    }

}
