package com.example.androidtrainingproject.model


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("bio")
    val bio: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("token")
    val token: String,
    @SerializedName("username")
    val username: String
)