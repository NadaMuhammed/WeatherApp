package com.example.network.interceptor

import com.example.network.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestWithApiKey =
            chain.request()
                .newBuilder()
                .header("key", BuildConfig.API_KEY)
                .build()

        return chain.proceed(requestWithApiKey)
    }
}