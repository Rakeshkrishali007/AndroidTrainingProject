package com.example.androidtrainingproject

import android.content.Intent
import android.content.SharedPreferences
import android.database.DatabaseErrorHandler
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.androidtrainingproject.model.User


public  lateinit var shrd:SharedPreferences
class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        shrd= getSharedPreferences("demo", MODE_PRIVATE)
        setContentView(R.layout.activity_splash)


        val user = shrd.getString("user", "null")
        if (user == "var123") {
            val user = User(
                shrd.getString("bio", "no").toString(),
                shrd.getString("email", "no").toString(),
                shrd.getString("image", "no").toString(),
                shrd.getString("bio", "no").toString(),
                shrd.getString("user", "no").toString()
            )

            val intent=Intent(this@Splash, DashBoard::class.java)
            Handler(Looper.getMainLooper()).postDelayed({
                intent.putExtra("USER", user)
                startActivity(intent)
            }, 1000)

        }
        else
        {
            val intent=Intent(this@Splash,MainActivity::class.java)
            Handler(Looper.getMainLooper()).postDelayed({
              startActivity(intent)
            }, 1000)

        }


    }
}