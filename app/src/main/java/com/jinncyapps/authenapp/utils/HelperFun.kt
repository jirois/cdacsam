package com.jinncyapps.authenapp.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

fun textWatcher(name: EditText?, emailText: EditText, passwordText: EditText, btn: Button): TextWatcher{
    val authTextWatcher: TextWatcher = object: TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val name: String = name?.text.toString().trim()
            val email: String = emailText.text.toString().trim()
            val password: String = passwordText.text.toString().trim()

            btn.isEnabled = name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()
        }

        override fun afterTextChanged(s: Editable?) {}

    }
    return authTextWatcher
}