package com.jinncyapps.authenapp.splash.onboarding.screens

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jinncyapps.authenapp.R
import com.jinncyapps.authenapp.auth.SignInActivity
import com.jinncyapps.authenapp.databinding.FragmentScreenTwoBinding

class ScreenTwo : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentScreenTwoBinding =DataBindingUtil.inflate(inflater, R.layout.fragment_screen__two, container, false)

        binding.tvBtnContinue.setOnClickListener {
            startActivity(Intent(context, SignInActivity::class.java))
        }

        return binding.root
    }


}