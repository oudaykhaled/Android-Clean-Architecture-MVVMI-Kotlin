package com.ouday.test.core.persistence;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ouday.test.customer.data.local.CustomerDao;
import com.ouday.test.customer.data.model.Customer;

@Database(entities = {Customer.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CustomerDao customerDao();
}
