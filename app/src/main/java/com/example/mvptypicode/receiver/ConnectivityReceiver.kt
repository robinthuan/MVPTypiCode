package com.example.mvptypicode.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager

class ConnectivityReceiver : BroadcastReceiver() {
    companion object {
        var connectivityReceiverListener: ConnectivityReceiverListener? = null
    }

    interface ConnectivityReceiverListener {
        fun onNetworkConnectChange(isConnected: Boolean)
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        if (connectivityReceiverListener != null) {
            connectivityReceiverListener?.onNetworkConnectChange(isConnected(context))
        }
    }

    private fun isConnected(context: Context?): Boolean {
        val connectionManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectionManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting
    }
}