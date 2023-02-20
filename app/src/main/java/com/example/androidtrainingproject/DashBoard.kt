package com.example.androidtrainingproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
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
        Toast.makeText(this@DashBoard, "${user?.username} is Loged In", Toast.LENGTH_SHORT).show()
        Glide.with(this).load(user?.image).into(binding2.imgProfilePic);
        binding2.btnLogout.setOnClickListener()
        {
            res= false
            val editor = shrd.edit()
            editor.clear().apply()
            Toast.makeText(this@DashBoard, "User Loged out", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@DashBoard, MainActivity::class.java))
            finish()
        }
    }

}