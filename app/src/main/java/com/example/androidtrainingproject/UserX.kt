package com.example.androidtrainingproject


import com.google.gson.annotations.SerializedName

data class UserX(
    @SerializedName("bio")
    val bio: Any,
    @SerializedName("email")
    val email: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("username")
    val username: String
)