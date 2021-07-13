package com.example.api

import com.example.api.services.MediumAPI
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MediumClient {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://conduit.productionready.io/api")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val api = retrofit.create(MediumAPI::class.java)
}