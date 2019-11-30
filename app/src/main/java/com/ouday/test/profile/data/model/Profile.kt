package com.ouday.test.profile.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Profile(
    val email: String,
    val firstName: String,
    val nickname: String,
    val secondName: String
): Parcelable