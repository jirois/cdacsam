package com.jinncyapps.cdacsam.splash.onboarding.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.jinncyapps.cdacsam.R
import com.jinncyapps.cdacsam.databinding.FragmentScreenFourBinding


class ScreenFour : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentScreenFourBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_screen_four, container, false)

        val viewPager =  activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.tvBtnContinue.setOnClickListener {
           findNavController().navigate(R.id.action_viewPager2_to_homeFragment)
        }
        return binding.root
    }

}