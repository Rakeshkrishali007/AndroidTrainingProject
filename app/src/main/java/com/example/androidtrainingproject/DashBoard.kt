package com.example.androidtrainingproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DashBoard : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)
       /* val text=findViewById<TextView>(R.id.usename)
        val image=findViewById<ImageView>(R.id.imageView)
        val img=intent.getStringExtra("image")
        val user=intent.getStringExtra("user")
        text.text=user.toString()
        Glide.with(this).load(img).into(image);
*/

    }
}