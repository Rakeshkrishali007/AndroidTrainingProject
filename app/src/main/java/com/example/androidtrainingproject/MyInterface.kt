package com.example.androidtrainingproject

import com.example.androidtrainingproject.model.request.LogInRequest
import com.example.androidtrainingproject.model.response.LogInResponse
import retrofit2.Call
import retrofit2.http.Body

import retrofit2.http.POST
const  val endPoint="users/login"
interface MyInterface {

    @POST(endPoint)
      fun getData(@Body user:LogInRequest
    ): Call<LogInResponse>

}
