package com.jinncyapps.cdacsam.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.jinncyapps.cdacsam.BaseActivity
import com.jinncyapps.cdacsam.R
import com.jinncyapps.cdacsam.ui.MainActivity

object FirebaseAuthUtil: BaseActivity() {

    fun signInUser(email: String, password: String){
        showProgressDialog(resources.getString(R.string.please_wait))

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->

                hideProgressDialog()

                if (task.isSuccessful) {
                    startActivity(Intent(this, MainActivity::class.java ))
                } else {
                    Toast.makeText(
                        this,
                        "Email/Password not correct",
                        Toast.LENGTH_LONG

                    ).show()
                }

            }
    }


    fun registerUser(email: String, password: String, context: Context){
        showProgressDialog(resources.getString(R.string.please_wait))

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{ task ->

                hideProgressDialog()

                if (task.isSuccessful) {
                    Toast.makeText(
                        context,
                        "Successfully register a user",
                        Toast.LENGTH_SHORT
                    ).show()
                    startActivity(Intent(context, MainActivity::class.java))

                }else {
                    Toast.makeText(
                        context,
                        task.exception!!.message,
                        Toast.LENGTH_SHORT
                        ).show()
                }
            }

    }
}

