package com.jinncyapps.cdacsam.auth.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupViewModel: ViewModel() {

    private var _username =  MutableLiveData<TextInputLayout>()

    private var _etUsername =  MutableLiveData<TextInputEditText>()
    val etUsername: MutableLiveData<TextInputEditText>
        get() = _etUsername

    private var _email =  MutableLiveData<TextInputLayout>()


    private var _etEmail =  MutableLiveData<TextInputEditText>()
    val etEmail: MutableLiveData<TextInputEditText>
        get() = _etEmail

    private var _password =  MutableLiveData<TextInputLayout>()

    private var _etPassword =  MutableLiveData<TextInputEditText>()
    val password: MutableLiveData<TextInputEditText>
        get() = _etPassword




}