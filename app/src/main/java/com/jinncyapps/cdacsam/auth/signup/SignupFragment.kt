package com.jinncyapps.cdacsam.auth.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.jinncyapps.cdacsam.R
import com.jinncyapps.cdacsam.databinding.FragmentSignUpBinding
import com.jinncyapps.cdacsam.firebase.FirestoreClass
import com.jinncyapps.cdacsam.model.User

class SignupFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentSignUpBinding.inflate(inflater, container, false)

        binding.cbTermsCondition.setOnCheckedChangeListener { buttonView, isChecked ->
            binding.btnSignup.isEnabled = isChecked
        }


        binding.btnSignup.setOnClickListener {
            registerUser()

        }


        return binding.root
    }


    private fun registerUser(){
        val usernameInput: String =binding.etSignupEmail.text.toString().trim()
        val emailInput: String = binding.etSignupEmail.text.toString().trim()
        val passwordInput: String = binding.etSignupPassword.text.toString().trim()

        if (!validateEmail(emailInput)
        ) {

            if (!validatePassword(passwordInput)){
                return
            }

        }

//        showProgressDialog(resources.getString(R.string.please_wait))
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailInput, passwordInput)
            .addOnCompleteListener(
                OnCompleteListener<AuthResult> { task ->

                    // Hide the progress dialog

//                    hideProgressDialog()
                    // If the registration is successfully done
                    if (task.isSuccessful) {

                        // Firebase registered user
                        val firebaseUser: FirebaseUser = task.result!!.user!!
                        // Registered Email
                        val registeredEmail = firebaseUser.email!!

                        val user = User(
                            firebaseUser.uid,
                            usernameInput,
                            registeredEmail
                        )

                        FirestoreClass().registerUser(this, user)

                    } else {
                        Toast.makeText(
                            requireContext(),
                            task.exception!!.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })

    }


    private fun validateEmail(email: String): Boolean{
        if (email.isEmpty()){
            binding.signupTextinputlayoutEmail.error = "Email Field can't be empty"
            return false
        } else if (email.length < 6){
            binding.signupTextinputlayoutEmail.error = "Email too short"
            return false
        }
        else {
            binding.signupTextinputlayoutEmail.error = null
            return true
        }
    }

    private fun validatePassword(password: String): Boolean{
        if (password.isEmpty()){
            binding.signupTextinputlayoutPassword.error = "Password Field can't be empty"
            return false
        } else if (password.length < 6){
            binding.signupTextinputlayoutPassword.error = "Password too short"
            return false
        } else {
            binding.signupTextinputlayoutPassword.error = null
            return true
        }
    }

    fun signinUserSuccess() {
        TODO("Not yet implemented")
    }

    fun userRegisterSuccess() {
        Toast.makeText(
            requireContext(),
            "You have successfully registered.",
            Toast.LENGTH_SHORT
        ).show()

        // Hide the progress dialog
//        hideProgressDialog()

        return
    }


}
