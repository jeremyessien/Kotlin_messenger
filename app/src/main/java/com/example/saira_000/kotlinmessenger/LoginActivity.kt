package com.example.saira_000.messenger

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.saira_000.kotlinmessenger.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginbutton.setOnClickListener {
            val email = login_email.text.toString()
            val password = login_password.text.toString()

            Log.d("Login", "Attempt login with email/pw: $email/***")
        }
        back_to_reg.setOnClickListener {
            finish()
        }
    }
}