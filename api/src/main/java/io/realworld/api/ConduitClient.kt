package io.realworld.api

import io.realworld.api.service.ConduitAPI
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class ConduitClient {

    val OkHttpClient = okhttp3.OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(1,TimeUnit.MINUTES)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://conduit.productionready.io/api/")
        .addConverterFactory(MoshiConverterFactory.create())
        .client(OkHttpClient)
        .build()


    val api = retrofit.create(ConduitAPI::class.java)



}