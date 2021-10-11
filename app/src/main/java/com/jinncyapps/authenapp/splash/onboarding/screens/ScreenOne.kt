package com.jinncyapps.authenapp.splash.onboarding.screens

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jinncyapps.authenapp.R
import com.jinncyapps.authenapp.SignInActivity
import com.jinncyapps.authenapp.databinding.FragmentScreenOneBinding


class ScreenOne : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentScreenOneBinding =DataBindingUtil.inflate(inflater, R.layout.fragment_screen__one, container, false)

        binding.tvBtnContinue.setOnClickListener {
            startActivity(Intent(context, SignInActivity::class.java))
        }

        return binding.root
    }

}