package com.example.androidtrainingproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.androidtrainingproject.databinding.ActivityDashBoardBinding
import com.example.androidtrainingproject.model.User

class DashBoard : AppCompatActivity() {


    lateinit var binding2: ActivityDashBoardBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding2 = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding2.root)
       /* val user=intent.getStringExtra("email")
        val image=intent.getStringExtra("image")
        binding2.etEmail.text=user.toString()
        Glide.with(this).load(image).into(binding2.imgProfilePic)*/


       /* val user= intent.getParcelableExtra<User>("USER")
             binding2.etEmail.text= user?.email.toString()*/
       /* if (user?.bio.toString() == null) {

            onVisibility(binding2.txtBioHead)
            onVisibility(binding2.txtBioSubheading)
        }
        Glide.with(this).load(user?.image).into(binding2.imgProfilePic);*/
    }

    /*private fun onVisibility(view: View) {
        view.setVisibility(View.VISIBLE)
    }*/


}