package com.jinncyapps.cdacsam

import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {

    private var doubleBackToExitPressedOnce = false

    private lateinit var mProgressionDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showProgressDialog(text: String){
        mProgressionDialog = Dialog(this)
        mProgressionDialog.setContentView(R.layout.progressbar_dialog)

        mProgressionDialog.findViewById<TextView>(R.id.tv_progress_text).text = text

        mProgressionDialog.show()
    }


    fun hideProgressDialog(){
        mProgressionDialog.dismiss()
    }


    fun doubleBackToExit(){
        if (doubleBackToExitPressedOnce){
            super.onBackPressed()
            return
        }

        this.doubleBackToExitPressedOnce = true
        Toast.makeText(
            this,
            resources.getString(R.string.please_wait),
            Toast.LENGTH_SHORT
        ).show()
        Handler().postDelayed({ doubleBackToExitPressedOnce = false}, 2000)
    }
}