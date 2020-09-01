package com.taweewong.mymvvmsample.extension

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat

fun <T> Context.openActivity(activity: Class<T>) {
    this.startActivity(Intent(this, activity))
}

fun <T> Context.openActivity(activity: Class<T>, bundle: Bundle) {
    this.startActivity(Intent(this, activity).apply {
        putExtras(bundle)
    })
}

fun Context.toast(text: String?) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Context.isNetworkConnected(): Boolean {
    val manager = ContextCompat.getSystemService(this, ConnectivityManager::class.java)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        manager?.let {
            val networkCapabilities = it.activeNetwork ?: return false
            val capabilities = it.getNetworkCapabilities(networkCapabilities) ?: return false
            return when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        }
    } else {
        manager?.let {
            it.activeNetworkInfo?.run {
                return when (type) {
                    ConnectivityManager.TYPE_WIFI -> true
                    ConnectivityManager.TYPE_MOBILE -> true
                    ConnectivityManager.TYPE_ETHERNET -> true
                    else -> false
                }
            }
        }
    }
    return false
}