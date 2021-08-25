package com.example.saira_000.messenger

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.saira_000.kotlinmessenger.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerbutton .setOnClickListener {
            val email = email.text.toString()
            val password = password.text.toString()

            if (email.isEmpty()|| password.isEmpty()) {
                Toast.makeText( this, "Please enter text in email/pw", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            Log.d("MainActivity", "Email is:$email")
            Log.d("MainActivity","Password:$password")

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            //if successful
                            Log.d("Main", "Successfully created user with uid: ${it.result!!.user?.uid}")
                        }
                        Log.d("Main", "user was not created with uid: ${it.result!!.user?.uid}")
                        //return@addOnCompleteListener
                    }
                .addOnFailureListener{
                    Log.d("Main", "Faied to create user: ${it.message}")
                }
        }
        alreadyhaveaccount.setOnClickListener {
            Log.d("MainActivity","Try to show login activity")
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}