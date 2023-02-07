package com.example.androidtrainingproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.androidtrainingproject.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var email:String
    lateinit var password:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getInfo()

    }

    private fun getInfo() {

        email=binding.gmail.text.toString()
        password=binding.password.text.toString()
        binding.press.setOnClickListener()
        {


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
                return@setOnClickListener
            }
            if(password.isEmpty())
            {
                Toast.makeText(this,"Password required",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if(password.length>6)
            {
                Toast.makeText(this,"Enter 6 digit password",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
                    Service.logininterface.getData(LogInRequest(User(email, password)))
                        .enqueue(object : Callback<LogInResponse> {
                            override fun onResponse(
                                call: Call<LogInResponse>,
                                response: retrofit2.Response<LogInResponse>
                            ) {
                                Log.d("success", "cool")
                                Toast.makeText(this@MainActivity, "success", Toast.LENGTH_SHORT)
                                    .show()

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