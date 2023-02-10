package com.example.androidtrainingproject.model.response


import com.example.androidtrainingproject.model.User
import com.google.gson.annotations.SerializedName

data class LogInResponse(
    @SerializedName("user")
    val user: User
)