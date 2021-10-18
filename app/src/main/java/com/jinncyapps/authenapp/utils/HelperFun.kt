package com.jinncyapps.authenapp.utils

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import java.util.*
import java.util.regex.Pattern

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

fun capitalizeString(str: String): String {
    var retStr = str
    try { // We can face index out of bound exception if the string is null
        retStr = str.substring(0, 1).uppercase() + str.substring(1)
    } catch (e: Exception) {
        Log.i(
            "Tag String",
            "Exception: $e"
        )
    }

    return retStr
}


fun getGreetingMessage():String{
    val c = Calendar.getInstance()
    val timeOfDay = c.get(Calendar.HOUR_OF_DAY)

    return when (timeOfDay) {
        in 0..11 -> "Good Morning"
        in 12..15 -> "Good Afternoon"
        in 16..20 -> "Good Evening"
        in 21..23 -> "Good Night"
        else -> "Hello"
    }
}
