package com.example.androidtrainingproject.model.request


import com.example.androidtrainingproject.model.LoginRequestParams
import com.google.gson.annotations.SerializedName

data class LogInRequest(
    @SerializedName("user")
    val user: LoginRequestParams
)