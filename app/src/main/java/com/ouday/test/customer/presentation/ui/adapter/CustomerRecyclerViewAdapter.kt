package com.ouday.test.customer.presentation.ui.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nostra13.universalimageloader.core.ImageLoader
import com.ouday.test.R
import com.ouday.test.customer.data.model.Customer
import kotlinx.android.synthetic.main.row_customer.view.*

class CustomerRecyclerViewAdapter(private val customers: List<Customer>): RecyclerView.Adapter<CustomerRecyclerViewAdapter.ViewHolder>() {

    private var onCustomerClickListener : ( (customer: Customer) -> Unit )? = null

    fun setOnCustomerClickListener( onCustomerClickListener: ((customer: Customer)->Unit)): CustomerRecyclerViewAdapter{
        this.onCustomerClickListener = onCustomerClickListener
        return this
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_customer, parent, false))
    }

    override fun getItemCount(): Int {
        return customers.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(customers[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bind(customer: Customer){
            itemView.tvPhoneNumber.text = customer.phoneNumber
            itemView.tvContactName.text = "${customer.firstName} ${customer.lastName}"
            ImageLoader.getInstance().displayImage(customer.profileImage, itemView.ivContact)
            itemView.setOnClickListener {
                onCustomerClickListener?.invoke(customer)
            }
        }

    }

}