package com.sdk.audiobook.manager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.sdk.audiobook.R
import com.sdk.audiobook.activity.no_internet.NoInternetActivity
import com.sdk.audiobook.util.NetworkHelper
import com.sdk.audiobook.util.toast

class CheckBroadcastManager: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (!hasInternet(context)) {
            context?.toast(context.getString(R.string.no_internet))
            context?.startActivity(Intent(context, NoInternetActivity::class.java))
        }
    }
    fun hasInternet(context: Context?): Boolean {
        val networkHelper = NetworkHelper(context!!)
        return networkHelper.isNetworkConnected()
    }
}