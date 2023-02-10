package com.example.androidtrainingproject

import com.example.androidtrainingproject.model.LoginRequestParams
import com.example.androidtrainingproject.model.User
import com.example.androidtrainingproject.model.request.LogInRequest
import com.example.androidtrainingproject.model.response.LogInResponse
import retrofit2.Call
import retrofit2.http.Body

import retrofit2.http.POST

interface MyInterface {

    @POST("users/login")
      fun getData(@Body user:LogInRequest
    ): Call<LogInResponse>

}
