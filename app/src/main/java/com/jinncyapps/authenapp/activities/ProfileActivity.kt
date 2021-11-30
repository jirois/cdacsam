package com.jinncyapps.authenapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.jinncyapps.authenapp.R
import com.jinncyapps.authenapp.firebase.FirestoreClass
import com.jinncyapps.authenapp.model.User

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        FirestoreClass().loadUserInfo(this)


    }
    fun userUI(user: User){
        val navUserImage = findViewById<ImageView>(R.id.iv_user_image)
        Glide
            .with(this@ProfileActivity)
            .load(user.image) // URL of the image
            .centerCrop() // Scale type of the image.
            .placeholder(R.drawable.ic_image_holder) // A default place holder
            .into(navUserImage) // the view in which the image will be loaded.

            Log.i("I/Image", user.image)
    }


}