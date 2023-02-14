package com.example.androidtrainingproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.androidtrainingproject.databinding.ActivityDashBoardBinding
import com.example.androidtrainingproject.databinding.ActivityMainBinding

class DashBoard : AppCompatActivity() {

    lateinit var binding: ActivityDashBoardBinding

        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityDashBoardBinding.inflate(layoutInflater)
            setContentView(binding.root)
            val em = intent.getStringExtra("gmail")
            val img = intent.getStringExtra("image")
            val userBio = intent.getStringExtra("userbio")
              binding.etEmail.text=em.toString()
              if(userBio==null)
              {
                  onVisibility(binding.txtBioHead)
                  onVisibility(binding.txtBioSubheading)
              }
              Glide.with(this).load(img).into(binding.imgProfilePic);

        }

    private fun onVisibility(view: View) {
        view.setVisibility(View.INVISIBLE)

    }


}