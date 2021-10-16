package com.jinncyapps.authenapp.auth

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.jinncyapps.authenapp.BaseActivity
import com.jinncyapps.authenapp.LandingActivity
import com.jinncyapps.authenapp.R
import com.jinncyapps.authenapp.databinding.ActivitySignInBinding

class SignInActivity : BaseActivity() {
    private lateinit var binding: ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.purple_700)
        }


        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)

        binding.etLoginEmail.addTextChangedListener(authTextWatcher)
        binding.etLoginPassword.addTextChangedListener(authTextWatcher)


        binding.etLoginEmail.doOnTextChanged { text, start, before, count ->
            if (text!!.length <= 6){
                binding.loginTextinputlayoutEmail.error= "Too few words"
            } else if (text.length  > 7) {
                binding.loginTextinputlayoutEmail.error= null
            }
        }
        binding.etLoginPassword.doOnTextChanged { text, start, before, count ->
            if (text!!.length <= 6){
                binding.loginTextinputlayoutPassword.error= "Password must be more than 6 letters"
            } else if (text.length > 6) {
                binding.loginTextinputlayoutPassword.error= null
            }
        }

        binding.btnSignin.setOnClickListener {
            signInUser()
        }

        binding.tvSignUpBtnText.setOnClickListener {
            startActivity(Intent(this@SignInActivity, SignUpActivity::class.java))
        }
    }



    private fun signInUser(){
        val emailtext: String = binding.etLoginEmail.text.toString()
        val passwordtext: String = binding.etLoginPassword.text.toString()

            showProgressDialog(resources.getString(R.string.please_wait))
            FirebaseAuth.getInstance().signInWithEmailAndPassword(emailtext, passwordtext)
                .addOnCompleteListener { task ->

                    //Hide progressbar
                    hideProgressDialog()

                    if (task.isSuccessful) {

                        Toast.makeText(
                            this@SignInActivity,
                            "You have successfully signed in.",
                            Toast.LENGTH_LONG
                        ).show()

                        startActivity(Intent(this@SignInActivity, LandingActivity::class.java))
                        finish()
                        return@addOnCompleteListener
                    } else {
                        Toast.makeText(
                            this@SignInActivity,
                            "Email/Password not correct",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }




    }

    private fun validateEmail(email: String): Boolean{
        val emailInput:String = email
        if (emailInput.isEmpty()){
            binding.loginTextinputlayoutEmail.error = "Email Field can't be empty"
            return false
        }
         else {
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

            binding.btnSignin.isEnabled = ( email.length > 6) && (password.length > 6)
        }

        override fun afterTextChanged(s: Editable?) {}
    }
}