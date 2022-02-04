package com.jinncyapps.cdacsam.auth.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.jinncyapps.cdacsam.R
import com.jinncyapps.cdacsam.databinding.FragmentLoginBinding
import com.jinncyapps.cdacsam.firebase.FirestoreClass


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by lazy {
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.etLoginEmail.addTextChangedListener(authTextWatcher)
        binding.etLoginPassword.addTextChangedListener(authTextWatcher)


        binding.etLoginEmail.doOnTextChanged { text, start, before, count ->
            if (text!!.length <= 6) {
                binding.loginTextinputlayoutEmail.error = "Too few words"
            } else if (text.length > 7) {
                binding.loginTextinputlayoutEmail.error = null
            }
        }
        binding.etLoginPassword.doOnTextChanged { text, start, before, count ->
            if (text!!.length <= 6) {
                binding.loginTextinputlayoutPassword.error = "Password must be more than 6 letters"
            } else if (text.length > 6) {
                binding.loginTextinputlayoutPassword.error = null
            }
        }
        binding.btnSignin.setOnClickListener {
            signInUser()
        }
        return  binding.root
    }




    private fun signInUser(){
        val emailtext: String = binding.etLoginEmail.text.toString()
        val passwordtext: String = binding.etLoginPassword.text.toString()

//        showProgressDialog(resources.getString(R.string.please_wait))
        FirebaseAuth.getInstance().signInWithEmailAndPassword(emailtext, passwordtext)
            .addOnCompleteListener { task ->

                //Hide progressbar
//                hideProgressDialog()

                if (task.isSuccessful) {

                    FirestoreClass().loadUserInfo(this)
//
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Email/Password not correct",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }




    }

    fun signinUserSuccess(){

        Toast.makeText(
            requireContext(),
            "You have successfully signed in.",
            Toast.LENGTH_LONG
        ).show()

//        startActivity(Intentnt(requireContext(), PermissionActivity::class.java))
//        finish()
        return

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


    private val authTextWatcher: TextWatcher = object: TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val email: String = binding.etLoginEmail.text.toString().trim()
            val password: String = binding.etLoginPassword.text.toString().trim()

            binding.btnSignin.isEnabled = ( email.length > 6) && (password.length > 6)
        }

        override fun afterTextChanged(s: Editable?) {}
    }
}
