package com.example.androidtrainingproject

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*
* ref: Medium(https://harshitabambure.medium.com/simple-retrofit-in-android-kotlin-5264b2839645)
*
* */

/*
* lazy in Kotlin is useful in a scenario when we want to create an object inside a class,
*   eg --
*       class Session {
       private val mentor: Mentor by lazy { Mentor() }
        }
* the object mentor will get initialized only when it is accessed for the first time, It will lead to the fast creation of the Session object
*   amitShekhar(https://amitshekhar.me/blog/lateinit-vs-lazy-in-kotlin)
* */
object RetrofitClient {
    val baseUrl = "https://conduit.productionready.io/api/"
/*
    var mHttmLogginInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    val mOkHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(mHttmLogginInterceptor)
        .build()*/

    /*val retrofit by lazy {
        Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
           // .client(mOkHttpClient)
            .build()
    }*/
    val retrofit=Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
    val logininterface= retrofit.create(MyInterface::class.java)
}