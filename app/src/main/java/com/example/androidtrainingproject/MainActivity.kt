package com.example.androidtrainingproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import com.example.androidtrainingproject.databinding.ActivityMainBinding
import com.example.androidtrainingproject.model.request.LogInRequest
import com.example.androidtrainingproject.model.response.LogInResponse
import com.example.androidtrainingproject.model.LoginRequestParams

import retrofit2.Call
import retrofit2.Callback


private const val TAG = "MainActivity_d"

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var email: String
    lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getInfo()
    }

    private fun getInfo() {

        binding.press.setOnClickListener()
        {

            email=binding.gmail.text.toString()
            password=binding.password.text.toString()
            if(email.isEmpty())
            {
                Toast.makeText(this,"Email required",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())


            {
                Toast.makeText(this,"Invalid email",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.isEmpty()) {
                Toast.makeText(this, "password required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if(password.length<6)
            {
                Toast.makeText(this,"password length must be greater then 8" +
                        "",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


                    RetrofitClient.logininterface.getData(LogInRequest(LoginRequestParams(email, password)))
                        .enqueue(object : Callback<LogInResponse> {
                            override fun onResponse(
                                call: Call<LogInResponse>,
                                response: retrofit2.Response<LogInResponse>
                            ) {
                            val intent= Intent(this@MainActivity,DashBoard::class.java)
                                startActivity(intent);
                                val username= response.body()?.user?.username
                                val image= response.body()?.user?.image
                                val eml=response.body()?.user?.email
                                val bio=response.body()?.user?.bio


                                if(username=="var123"&&password=="123123123")
                                {
                                    val intent= Intent(this@MainActivity,DashBoard::class.java)
                                    intent.putExtra("user",username)
                                    intent.putExtra("image",image)
                                    intent.putExtra("gmail",eml)
                                    intent.putExtra("userbio",bio)
                                    startActivity(intent)
                                }
                                else{
                                    Toast.makeText(this@MainActivity,"Invalid user",Toast.LENGTH_SHORT).show()

                                }




                            }
                        override fun onFailure(call: Call<LogInResponse>, t: Throwable) {

                            Log.e("error", "bad")
                            Toast.makeText(this@MainActivity, "error", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }
                    )
            }

        }


}