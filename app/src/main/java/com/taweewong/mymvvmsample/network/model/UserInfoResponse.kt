package com.taweewong.mymvvmsample.network.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserInfoResponse(
    val id: String?,
    val name: String?
) : Parcelable