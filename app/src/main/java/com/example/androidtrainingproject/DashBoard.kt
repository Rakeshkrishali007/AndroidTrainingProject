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

    lateinit var binding2: ActivityDashBoardBinding

        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding2 = ActivityDashBoardBinding.inflate(layoutInflater)
            setContentView(binding2.root)
            val em = intent.getStringExtra("gmail")
            val img = intent.getStringExtra("image")
            val userBio = intent.getStringExtra("userbio")
              binding2.etEmail.text=em.toString()
              if(userBio==null)
              {
                  onVisibility(binding2.txtBioHead)
                  onVisibility(binding2.txtBioSubheading)
              }
              Glide.with(this).load(img).into(binding2.imgProfilePic);

        }

    private fun onVisibility(view: View) {
        view.setVisibility(View.INVISIBLE)

    }


}