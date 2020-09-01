package com.taweewong.mymvvmsample.network.core

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ErrorResponse(
    val errorMessage: String
) : Parcelable