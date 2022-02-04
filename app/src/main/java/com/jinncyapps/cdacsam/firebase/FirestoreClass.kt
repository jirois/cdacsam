package com.jinncyapps.cdacsam.firebase

import android.util.Log
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.jinncyapps.cdacsam.auth.signup.SignupFragment
import com.jinncyapps.cdacsam.model.User
import com.jinncyapps.cdacsam.utils.Constants

class FirestoreClass {
    private val mFirestore = FirebaseFirestore.getInstance()

    fun registerUser(fragment: SignupFragment, userInfo: User){
        mFirestore.collection(Constants.USERS)
            .document(getCurrentID())
            .set(userInfo, SetOptions.merge())
            .addOnSuccessListener {
                fragment.userRegisterSuccess()
            }
            .addOnFailureListener {e ->
                Log.e(
                    fragment.javaClass.simpleName,
                    "Error while getting loggedIn user details",
                    e
                )
            }
    }
    fun loadUserInfo(fragment: Fragment){
        mFirestore.collection(Constants.USERS)
            .document(getCurrentID())
            .get()
            .addOnSuccessListener { document ->
                Log.e(
                    fragment.javaClass.simpleName, document.toString()
                )
                val loggedUser = document.toObject(User::class.java)!!
                when (fragment){
                    is SignupFragment -> {
                        fragment.signinUserSuccess()
                    }


                }

            }
            .addOnFailureListener {e ->
                when (fragment){
                    is SignupFragment -> {
//                        fragment.hideProgressDialog()
                    }
                }
                Log.e(
                    fragment.javaClass.simpleName,
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