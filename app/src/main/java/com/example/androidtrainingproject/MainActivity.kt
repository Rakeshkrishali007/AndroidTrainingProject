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
@SuppressLint("StaticFieldLeak")
lateinit var binding:ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var email: String
    lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getInfo()
        Log.d("success","main")
    }

    private fun getInfo() {

        binding.press.setOnClickListener()
        {

           email = binding.etGmail.text.toString()
            password = binding.etPassword.text.toString()


            if(email.isEmpty())
            {

            }
            else {
                RetrofitClient.logininterface.getData(
                    LogInRequest(
                        LoginRequestParams(
                            email,
                            password
                        )
                    )
                )
                    .enqueue(object : Callback<LogInResponse> {
                        @SuppressLint("SuspiciousIndentation")
                        override fun onResponse(
                            call: Call<LogInResponse>,
                            response: retrofit2.Response<LogInResponse>
                        ) {
                            if(response.code().equals("200"))
                            {
                                val username = response.body()?.user?.username
                                val image = response.body()?.user?.image
                                val eml = response.body()?.user?.email
                                val bio = response.body()?.user?.bio
                                val intent = Intent(this@MainActivity, DashBoard::class.java)
                                intent.putExtra("image", image)
                                intent.putExtra("gmail", eml)
                                intent.putExtra("userbio", bio)
                                startActivity(intent)

                            }
                            else
                            {
                                Toast.makeText(this@MainActivity,"Invalid user",Toast.LENGTH_LONG).show()
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


}