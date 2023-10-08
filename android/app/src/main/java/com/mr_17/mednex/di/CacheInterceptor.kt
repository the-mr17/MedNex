package com.mr_17.mednex.di

import android.content.Context
import com.mr_17.mednex.utils.NetworkUtils
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CacheInterceptor @Inject constructor(
    @ApplicationContext private val context: Context
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        if(NetworkUtils.isOnline(context.applicationContext)) {
            return chain.proceed(request)
        }

        val cacheControl = CacheControl.Builder()
            .onlyIfCached()
            .maxStale(7, TimeUnit.DAYS)
            .build()

        request.newBuilder()
            .cacheControl(cacheControl)
            .build()

        return chain.proceed(request)
    }
}
