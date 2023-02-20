package com.example.androidtrainingproject

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import com.example.androidtrainingproject.databinding.ActivityMainBinding
import com.example.androidtrainingproject.model.request.LogInRequest
import com.example.androidtrainingproject.model.response.LogInResponse
import com.example.androidtrainingproject.model.LoginRequestParams
import com.example.androidtrainingproject.model.User
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback


@SuppressLint("StaticFieldLeak")
public var res: Boolean? = false
private lateinit var editor: Editor

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var email: String
    lateinit var password: String
    lateinit var internet:InternetConnection


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getInfo()

    }

    private fun getInfo() {

        editor = shrd.edit()

        binding.progressBar1.visibility = View.INVISIBLE
        var res = shrd.getBoolean("ans", false)
        if (res) {

            val intent = Intent(this@MainActivity, DashBoard::class.java)
            val user = User(
                shrd.getString("bio", "no").toString(),
                shrd.getString("email", "no").toString(),
                shrd.getString("image", "no").toString(),
                shrd.getString("bio", "no").toString(),
                shrd.getString("user", "no").toString()
            )
            intent.putExtra("USER", user)

            startActivity(intent)
            finish()
        } else {

            binding.btnLogin.setOnClickListener() {


                email = binding.etGmail.text.toString()
                password = binding.etPassword.text.toString()

                if (isValid()) {
                    internet=InternetConnection()
                    if (internet.isConnected(this)) {
                        binding.progressBar1.visibility = View.VISIBLE

                        RetrofitClient.logininterface.getData(
                            LogInRequest(
                                LoginRequestParams(
                                    email, password
                                )
                            )
                        ).enqueue(object : Callback<LogInResponse> {
                            @SuppressLint("SuspiciousIndentation")
                            override fun onResponse(
                                call: Call<LogInResponse>,
                                response: retrofit2.Response<LogInResponse>
                            ) {
                                if (response.code().toString().equals("200")) {
                                    res = true
                                    binding.progressBar1.visibility = View.VISIBLE

                                    val intent = Intent(this@MainActivity, DashBoard::class.java)
                                    val username = response.body()?.user?.username
                                    val image = response.body()?.user?.image
                                    val eml = response.body()?.user?.email
                                    val bio = response.body()?.user?.bio
                                    val token = response.body()?.user?.token
                                    editor.putString("user", username.toString())
                                    editor.putString("email", eml.toString())
                                    editor.putString("image", image.toString())
                                    editor.putString("bio", bio.toString())
                                    editor.putString("token", token.toString())
                                    editor.putBoolean("ans", res)
                                    editor.apply()
                                    val user = User(
                                        bio.toString(),
                                        eml.toString(),
                                        image.toString(),
                                        token.toString(),
                                        username.toString()
                                    )
                                    intent.putExtra("USER", user)
                                    startActivity(intent)
                                    finish()

                                } else {

                                    binding.progressBar1.visibility = View.INVISIBLE

                                    Toast.makeText(
                                        this@MainActivity, "Invalid user", Toast.LENGTH_LONG
                                    ).show()
                                }
                            }

                            override fun onFailure(call: Call<LogInResponse>, t: Throwable) {

                                Log.e("error", "bad")
                                Toast.makeText(this@MainActivity, "error", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        })

                    } else {
                        val snack =
                            Snackbar.make(it, "Not connected to Internet", Snackbar.LENGTH_LONG)
                        snack.show()
                    }

                } else {

                    binding.progressBar1.visibility = View.INVISIBLE
                }
            }
        }

    }


    private fun isValid(): Boolean {
        if (email.isEmpty() && password.isEmpty()) {
            Toast.makeText(this@MainActivity, "Email & Password required", Toast.LENGTH_SHORT)
                .show()
            return false
        } else if (email.isEmpty()) {

            Toast.makeText(this, "Email required", Toast.LENGTH_SHORT).show()
            return false

        } else if (password.isEmpty()) {
            Toast.makeText(this@MainActivity, "password required", Toast.LENGTH_LONG).show()
            return false

        } else if (password.length < 6) {
            Toast.makeText(this@MainActivity, "Minimum password length 6", Toast.LENGTH_SHORT)
                .show()
            return false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.toString().trim()).matches()) {
            Toast.makeText(this@MainActivity, "invalid email", Toast.LENGTH_SHORT).show()
            return false

        }
        return true
    }


}