package com.example.androidtrainingproject

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface MyInterface {
    @POST("users/login")
    fun getData(@Body user:LogInRequest): Call<LogInResponse>

}