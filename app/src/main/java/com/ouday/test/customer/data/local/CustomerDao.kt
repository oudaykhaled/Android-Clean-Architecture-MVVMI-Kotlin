package com.ouday.test.customer.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ouday.test.customer.data.model.Customer

@Dao
interface CustomerDao {

    @Insert
    suspend fun insertAll(customers: Array<Customer>)

    @Query("SELECT * from customer")
    fun getAllCustomers(): List<Customer>

    @Update
    fun update(customer: Customer)
}