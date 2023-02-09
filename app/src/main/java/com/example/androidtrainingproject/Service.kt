package com.example.androidtrainingproject

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Service {
    private val client = OkHttpClient.Builder().build()
    val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://conduit.productionready.io/api/").addConverterFactory(
            GsonConverterFactory.create()).client(client).build()
    }
    val logininterface= retrofit.create(MyInterface::class.java)
}

