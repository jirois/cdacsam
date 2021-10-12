package com.jinncyapps.authenapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.jinncyapps.authenapp.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.purple_700)
        }


        binding = DataBindingUtil.setContentView(this,R.layout.activity_sign_in)

        binding.etLoginEmail.addTextChangedListener(authTextWatcher)
        binding.etLoginPassword.addTextChangedListener(authTextWatcher)


        binding.etLoginEmail.doOnTextChanged { text, start, before, count ->
            if (text!!.length > 10){
                binding.loginTextinputlayoutEmail.error= "No more"
            } else if (text.length < 10) {
                binding.loginTextinputlayoutEmail.error= null
            }
        }

        binding.btnSignin.setOnClickListener {
            signInUser()
        }

        binding.tvSignUpBtnText.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }



    private fun signInUser(){
        val emailtext: String = binding.etLoginEmail.text.toString()
        val passwordtext: String = binding.etLoginPassword.text.toString()

        if (!validateEmail(emailtext) && !validatePassword(passwordtext)){
            FirebaseAuth.getInstance().signInWithEmailAndPassword(emailtext, passwordtext)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {

                        Toast.makeText(
                            this@SignInActivity,
                            "You have successfully signed in.",
                            Toast.LENGTH_LONG
                        ).show()

                        startActivity(Intent(this@SignInActivity, MainActivity::class.java))
                    } else {
                        Toast.makeText(
                            this@SignInActivity,
                            task.exception!!.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

        }


    }

    private fun validateEmail(email: String): Boolean{
        val emailInput:String = email
        if (emailInput.isEmpty()){
            binding.loginTextinputlayoutEmail.error = "Email Field can't be empty"
            return false
        } else if (Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            binding.loginTextinputlayoutEmail.error = "Please enter a valid email address"
            return false
        } else {
            binding.loginTextinputlayoutEmail.error = null
            return true
        }
    }

    private fun validatePassword(password: String): Boolean{
        val usernameInput:String = password
        if (usernameInput.isEmpty()){
            binding.loginTextinputlayoutEmail.error = "Password Field can't be empty"
            return false
        } else {
            binding.loginTextinputlayoutEmail.error = null
            return true
        }
    }


    val authTextWatcher: TextWatcher = object: TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val email: String = binding.etLoginEmail.text.toString().trim()
            val password: String = binding.etLoginPassword.text.toString().trim()

            binding.btnSignin.isEnabled = email.isNotEmpty() && password.isNotEmpty()
        }

        override fun afterTextChanged(s: Editable?) {}
    }
}