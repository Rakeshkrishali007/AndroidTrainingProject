package com.example.androidtrainingproject


import com.google.gson.annotations.SerializedName

data class LogInRequest(
    @SerializedName("user")
    val user: User
)