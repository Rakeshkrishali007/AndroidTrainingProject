package com.example.androidtrainingproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class DashBoard : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dash_board)
        val email=findViewById<TextView>(R.id.email)
        val image=findViewById<ImageView>(R.id.profile_pic)
        val bio=findViewById<TextView>(R.id.about)
        val aboutHeading=findViewById<TextView>(R.id.txt_bio_head)
        val img=intent.getStringExtra("image")
        val em=intent.getStringExtra("gmail")
        val  userBio=intent.getStringExtra("userbio")
        email.text=em.toString()

        if (userBio == null) {
            onVisibility(bio)
            onVisibility(aboutHeading)
        } else {
            bio.text=userBio.toString()
        }
//        Glide.with(this).load(img).into(image);


    }


    private fun onVisibility(view: View) {
        view.setVisibility(View.INVISIBLE)

    }


}