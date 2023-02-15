package com.example.androidtrainingproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.androidtrainingproject.databinding.ActivityDashBoardBinding

class DashBoard : AppCompatActivity() {

    lateinit var binding:ActivityDashBoardBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val image=intent.getStringExtra("image")
        val email=intent.getStringExtra("gmail")
        val bio=intent.getStringExtra("bio")

        binding.etEmail.text=email.toString()
        binding.txtBioSubheading.text=bio
      Glide.with(this).load(image).into(binding.imgProfilePic);


    }


    private fun onVisibility(view: View) {
        view.setVisibility(View.VISIBLE)

    }


}