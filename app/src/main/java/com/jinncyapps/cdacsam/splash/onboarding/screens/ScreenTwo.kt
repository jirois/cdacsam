package com.jinncyapps.cdacsam.splash.onboarding.screens

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jinncyapps.cdacsam.R
import com.jinncyapps.cdacsam.databinding.FragmentScreenFourBinding
import com.jinncyapps.cdacsam.databinding.FragmentScreenTwoBinding
import com.jinncyapps.cdacsam.ui.MainActivity


class ScreenTwo : Fragment() {
    private lateinit var binding:FragmentScreenTwoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScreenTwoBinding.inflate(inflater, container, false)

        binding.tvBtnContinue.setOnClickListener {
            startActivity(Intent(requireContext(), MainActivity::class.java))
        }
        return binding.root
    }

}