package com.example.androidtrainingproject


import com.google.gson.annotations.SerializedName

data class LogInResponse(
    @SerializedName("user")
    val user: UserX
)