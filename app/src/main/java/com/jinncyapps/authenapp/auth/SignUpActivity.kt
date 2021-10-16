package com.jinncyapps.authenapp.auth

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.jinncyapps.authenapp.BaseActivity
import com.jinncyapps.authenapp.R
import com.jinncyapps.authenapp.databinding.ActivitySignUpBinding

class SignUpActivity : BaseActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.purple_700)
        }

//        val usernameInput: String = binding.etSigninUsername.text.toString().trim()
//        val emailInput: String = binding.etSigninEmail.text.toString().trim()
//        val passwordInput: String = binding.etSigninPassword.text.toString().trim()

        binding.chTermConditionCheck.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.btnSignup.isEnabled = isChecked
        }



        binding.btnSignup.setOnClickListener {
            registerUser()

        }

    }



    private fun registerUser(){
        val usernameInput: String = binding.etSigninUsername.text.toString().trim()
        val emailInput: String = binding.etSigninEmail.text.toString().trim()
        val passwordInput: String = binding.etSigninPassword.text.toString().trim()

        if (!validateEmail(emailInput)
        ) {

                if (!validatePassword(passwordInput)){
                    return
                }

        }

        showProgressDialog(resources.getString(R.string.please_wait))
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailInput, passwordInput)
            .addOnCompleteListener(
                OnCompleteListener<AuthResult> { task ->

                    // Hide the progress dialog

                    hideProgressDialog()
                    // If the registration is successfully done
                    if (task.isSuccessful) {

                        // Firebase registered user
                        val firebaseUser: FirebaseUser = task.result!!.user!!
                        // Registered Email
                        val registeredEmail = firebaseUser.email!!

                        Toast.makeText(
                            this@SignUpActivity,
                            "you have successfully registered with email id $registeredEmail.",
                            Toast.LENGTH_SHORT
                        ).show()

                        /**
                         * Here the new user registered is automatically signed-in so we just sign-out the user from firebase
                         * and send him to Intro Screen for Sign-In
                         */


                        /**
                         * Here the new user registered is automatically signed-in so we just sign-out the user from firebase
                         * and send him to Intro Screen for Sign-In
                         */
                        startActivity(
                            Intent(
                                this@SignUpActivity,
                                SignInActivity::class.java
                            )
                        )
                        // Finish the Sign-Up Screen
//                            finish()
                    } else {
                        Toast.makeText(
                            this@SignUpActivity,
                            task.exception!!.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })




}


    private fun validateName(name: String): Boolean{
        if (name.isEmpty()){
            binding.signinTextinputlayoutUsername.error = "Username can't be empty"
            return false
        } else if(name.length > 20){
            binding.signinTextinputlayoutUsername.error = "Username too long"
            return false
        } else {
            binding.signinTextinputlayoutUsername.error = null
            return true
        }
    }

    private fun validateEmail(email: String): Boolean{
        if (email.isEmpty()){
            binding.signinTextinputlayoutEmail.error = "Email Field can't be empty"
            return false
        } else if (email.length < 6){
            binding.signinTextinputlayoutEmail.error = "Email too short"
            return false
        }
        else {
            binding.signinTextinputlayoutEmail.error = null
            return true
        }
    }

    private fun validatePassword(password: String): Boolean{
        if (password.isEmpty()){
            binding.signinTextinputlayoutPassword.error = "Password Field can't be empty"
            return false
        } else if (password.length < 6){
            binding.signinTextinputlayoutPassword.error = "Password too short"
            return false
        } else {
            binding.signinTextinputlayoutPassword.error = null
            return true
        }
    }




}