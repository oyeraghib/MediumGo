package io.realworld.api

import io.realworld.api.service.ConduitAPI
import io.realworld.api.service.ConduitAuthAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


object ConduitClient {

    var authToken: String? = null
    const val BASE_URL = "https://conduit.productionready.io/api/"

    private val authInterceptor = Interceptor { chain ->
        var req = chain.request()
        authToken?.let {
            req = req.newBuilder()
                .header("Authorization", "Token$it")
                .build()
        }
        chain.proceed(req)
    }


    val okHttpBuilder = OkHttpClient.Builder()
        .addInterceptor(authInterceptor)
        .readTimeout(5, TimeUnit.MINUTES)
        .connectTimeout(2, TimeUnit.MINUTES)

    val retrofitBuilder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpBuilder.build())
        .addConverterFactory(MoshiConverterFactory.create())


    val publicApi = retrofitBuilder
        .build()
        .create(ConduitAPI::class.java)

    val authApi = retrofitBuilder
        .build()
        .create(ConduitAuthAPI::class.java)

}




