package com.jinncyapps.cdacsam.auth.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.jinncyapps.cdacsam.utils.FirebaseAuthUtil

class LoginViewModel: ViewModel() {

    private var _email =  MutableLiveData<TextInputLayout>()


    private var _etEmail =  MutableLiveData<TextInputEditText>()
    val etMail: MutableLiveData<TextInputEditText>
     get() = _etEmail


    private var _password =  MutableLiveData<TextInputLayout>()

    private var _etPassword =  MutableLiveData<TextInputLayout>()
    val etPassword: MutableLiveData<TextInputLayout>
     get() = _etPassword



    init {
        loginUser()
    }

    private fun loginUser() {
        if (!validateEmail(_etEmail.value.toString())){
            if (!validatePassword(_etPassword.value.toString())){
                return
            }
        }

        FirebaseAuthUtil.signInUser(_etEmail.value.toString(), _etPassword.value.toString())
    }


    private fun validateEmail(email: String): Boolean{
        if (email.isEmpty()){
            _email.value?.error = "Email Field can't be blank"
            return false
        } else if (email.length < 6) {
            _email.value?.error = "Email too short"
            return false
        } else {
            _email.value?.error = null
            return true
        }
    }


    private fun validatePassword(password: String): Boolean{
        if (password.isEmpty()){
            _password.value?.error = "Email Field can't be blank"
            return false
        } else if (password.length < 6) {
            _password.value?.error = "Email too short"
            return false
        } else {
            _password.value?.error = null
            return true
        }
    }




}
    