package com.jinncyapps.authenapp.firebase

import android.app.Activity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.google.firebase.ktx.Firebase
import com.jinncyapps.authenapp.LandingActivity
import com.jinncyapps.authenapp.auth.SignInActivity
import com.jinncyapps.authenapp.auth.SignUpActivity
import com.jinncyapps.authenapp.model.User
import com.jinncyapps.authenapp.utils.Constants

class FirestoreClass {

    private val mFirestore = FirebaseFirestore.getInstance()

    fun registerUser(activity: SignUpActivity, userInfo: User){
        mFirestore.collection(Constants.USERS)
            .document(getCurrentID())
            .set(userInfo, SetOptions.merge())
            .addOnSuccessListener {
                activity.userRegisterSuccess()
            }
            .addOnFailureListener {e ->
                Log.e(
                    activity.javaClass.simpleName,
                    "Error while getting loggedIn user details",
                    e
                )
            }
    }
    fun signInUser(activity: Activity){
        mFirestore.collection(Constants.USERS)
            .document(getCurrentID())
            .get()
            .addOnSuccessListener { document ->
                Log.e(
                    activity.javaClass.simpleName, document.toString()
                )
                val loggedUser = document.toObject(User::class.java)!!
                when (activity){
                    is SignInActivity -> {
                        activity.signinUserSuccess()
                    }
                    is LandingActivity -> {
                        activity.updateNavigationUserSuccess(loggedUser)
                    }
                }
                
            }
            .addOnFailureListener {e ->
                Log.e(
                    activity.javaClass.simpleName,
                    "Error while getting loggedIn user details",
                    e
                )
            }
    }


    fun getCurrentID():String {
        val currentUser = FirebaseAuth.getInstance().currentUser
        var currentID: String = ""
        if (currentUser != null){
            currentID = currentUser.uid
        }
        return currentID
    }
}