package com.example.androidtrainingproject

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Service {
    val retrofit by lazy {
        Retrofit.Builder().baseUrl("https://conduit.productionready.io/api/").addConverterFactory(
            GsonConverterFactory.create()).build()
    }
    val logininterface= retrofit.create(MyInterface::class.java)
}