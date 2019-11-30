package com.ouday.test.customer.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Customer(
    val id: String,
    val firstName: String,
    val lastName: String,
    val mobileNumber: String,
    val phoneNumber: String,
    val address: String,
    val profileImage: String
): Parcelable