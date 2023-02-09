package com.example.androidtrainingproject

import android.provider.ContactsContract.CommonDataKinds.Email
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyInterface {

    @POST("users/login")
      fun getData(@Body user: User
    ): Call<LogInResponse>

}
