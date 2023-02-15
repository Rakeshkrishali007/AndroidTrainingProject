package com.example.androidtrainingproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class DashBoard : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dash_board)
//        val email=findViewById<TextView>(R.id.txt_email)
//        val image=findViewById<ImageView>(R.id.profile_pic)
        val bio=findViewById<TextView>(R.id.txt_bio_subheading)
        val aboutHeading=findViewById<TextView>(R.id.txt_bio_head)
        val img=intent.getStringExtra("image")
        val em=intent.getStringExtra("gmail")
        var  userBio=intent.getStringExtra("userbio")
//        email.text=em.toString()

/*        if (userBio == null) {
            onVisibility(bio)
            onVisibility(aboutHeading)
        } else {
            bio.text=userBio.toString()
        }
        */


        userBio?.let {
            onVisibility(bio)
            onVisibility(aboutHeading)
        }
//        Glide.with(this).load(img).into(image);


    }


    private fun onVisibility(view: View) {
        view.setVisibility(View.VISIBLE)

    }


}