package com.ouday.test.profile.data.remote.services.requests

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginRequest(
    val username: String,
    val password: String
): Parcelable