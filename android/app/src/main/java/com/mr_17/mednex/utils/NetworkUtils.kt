package com.mr_17.mednex.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.google.gson.Gson
import com.mr_17.mednex.data.ErrorResponse
import okhttp3.ResponseBody

object NetworkUtils {
    fun isOnline(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val n = cm.activeNetwork
        if (n != null) {
            val nc = cm.getNetworkCapabilities(n)
            //It will check for both wifi and cellular network
            return nc!!.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                    || nc.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
        }
        return false
    }

    fun ResponseBody.getErrorJson(): ErrorResponse? {
        return Gson().fromJson(this.charStream(), ErrorResponse::class.java)
    }
}