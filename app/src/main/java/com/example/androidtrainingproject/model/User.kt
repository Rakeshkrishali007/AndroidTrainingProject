package com.example.androidtrainingproject.model


import android.os.Parcel
import android.os.Parcelable
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
):Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(bio)
        parcel.writeString(email)
        parcel.writeString(image)
        parcel.writeString(token)
        parcel.writeString(username)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }

}
