package com.jinncyapps.authenapp.splash.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.ViewBindingAdapter
import com.google.android.material.tabs.TabLayoutMediator
import com.jinncyapps.authenapp.R
import com.jinncyapps.authenapp.databinding.FragmentViewPagerBinding
import com.jinncyapps.authenapp.splash.onboarding.screens.ScreenFour
import com.jinncyapps.authenapp.splash.onboarding.screens.ScreenOne
import com.jinncyapps.authenapp.splash.onboarding.screens.ScreenThree
import com.jinncyapps.authenapp.splash.onboarding.screens.ScreenTwo


class ViewPager : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentViewPagerBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf(
            ScreenOne(),
            ScreenTwo(),
            ScreenThree(),
            ScreenFour()
        )

        val adapter = ViewPagerAdapter(
            fragmentList,
            requireActivity().supportFragmentManager,
            lifecycle
        )

        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager){ tab, position ->
        }.attach()

        return binding.root
    }

}