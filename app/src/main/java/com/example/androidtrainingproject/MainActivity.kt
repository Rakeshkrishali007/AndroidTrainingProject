package com.example.androidtrainingproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.androidtrainingproject.databinding.ActivityMainBinding
import com.example.androidtrainingproject.model.request.LogInRequest
import com.example.androidtrainingproject.model.response.LogInResponse
import com.example.androidtrainingproject.model.LoginRequestParams

import retrofit2.Call
import retrofit2.Callback


private const val TAG = "MainActivity_d"

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var email: String
    lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getInfo()
    }

    private fun getInfo() {

        email = "var123@gmail.com"
        password = "123123123"


        binding.press.setOnClickListener()
        {



    /*        email=binding.gmail.text.toString()
            password=binding.password.text.toString()

           Toast.makeText(this,"${email.length}",Toast.LENGTH_SHORT).show()
            Toast.makeText(this,"${password.length}",Toast.LENGTH_SHORT).show()
            if(email.isEmpty())
            {
                Toast.makeText(this,"Email required",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            {
                Toast.makeText(this,"Invalid email",Toast.LENGTH_SHORT).show()
            }
            if (password.isEmpty()) {
                Toast.makeText(this, "password required", Toast.LENGTH_SHORT).show()
            }
            else if(password.length<6)
            {
                Toast.makeText(this,"Maximum password length 9",Toast.LENGTH_SHORT).show()
            }

     */
                    RetrofitClient.logininterface.getData(LogInRequest(LoginRequestParams(email, password)))
                        .enqueue(object : Callback<LogInResponse> {
                            override fun onResponse(
                                call: Call<LogInResponse>,
                                response: retrofit2.Response<LogInResponse>
                            ) {
                                Log.d(TAG, "LoginData: " + response.body().toString())

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