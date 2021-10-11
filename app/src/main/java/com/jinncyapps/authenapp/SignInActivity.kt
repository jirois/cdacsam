package com.jinncyapps.authenapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    lateinit var emailText: EditText
    lateinit var passwordText: EditText
    lateinit var signUp: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

//        emailText = findViewById(R.id.tv_email_login)
//        passwordText = findViewById(R.id.tv_password_login)
//
//        signUp.setOnClickListener {
//            val email:String = emailText.text.toString().trim()
//            val password:String = passwordText.text.toString().trim()
//
//            Toast.makeText(
//                this@SignInActivity,
//                "email: $email, password: $password",
//                Toast.LENGTH_LONG
//            ).show()
//        }
    }
}