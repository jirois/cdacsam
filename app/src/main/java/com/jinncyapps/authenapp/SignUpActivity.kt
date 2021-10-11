package com.jinncyapps.authenapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.jinncyapps.authenapp.utils.textWatcher

class SignUpActivity : AppCompatActivity() {
    lateinit var emailText: EditText
    lateinit var passwordText: EditText
    lateinit var signUpBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        emailText = findViewById(R.id.et_email)
        passwordText = findViewById(R.id.et_password)
        signUpBtn = findViewById(R.id.btn_signup)

        emailText.addTextChangedListener(authTextWatcher)
        passwordText.addTextChangedListener(authTextWatcher)





        signUpBtn.setOnClickListener {
            val email: String = emailText.text.toString()
            val password: String = passwordText.text.toString()
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                    OnCompleteListener<AuthResult> { task ->

                        // Hide the progress dialog


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
                             startActivity(Intent(this@SignUpActivity, SignInActivity::class.java))
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
    }


  private val authTextWatcher: TextWatcher = object:TextWatcher{
      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
          val email: String = emailText.text.toString().trim()
          val password: String = passwordText.text.toString().trim()

          signUpBtn.isEnabled = email.isNotEmpty() && password.isNotEmpty()
      }

      override fun afterTextChanged(s: Editable?) {}

  }


}