package com.example.androidtrainingproject

import android.annotation.SuppressLint
import android.content.Intent
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
        val user = intent.getParcelableExtra<User>("USER")
        binding2.etEmail.text = user?.email.toString()
        if (user?.bio.toString() == null) {

            onVisibility(binding2.txtBioHead)
            onVisibility(binding2.txtBioSubheading)
        }
        Glide.with(this).load(user?.image).into(binding2.imgProfilePic);
        binding2.btnLogout.setOnClickListener()
        {
            val intent=Intent(this@DashBoard,MainActivity::class.java)
            res=false
            editor.clear()
            startActivity(intent)
        }
    }

    private fun onVisibility(view: View) {
        view.setVisibility(View.VISIBLE)
    }


}