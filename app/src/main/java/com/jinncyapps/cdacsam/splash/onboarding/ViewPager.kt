package com.jinncyapps.cdacsam.splash.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.jinncyapps.cdacsam.databinding.FragmentViewPagerBinding
import com.jinncyapps.cdacsam.splash.onboarding.screens.ScreenFour
import com.jinncyapps.cdacsam.splash.onboarding.screens.ScreenOne
import com.jinncyapps.cdacsam.splash.onboarding.screens.ScreenThree
import com.jinncyapps.cdacsam.splash.onboarding.screens.ScreenTwo

class ViewPager: Fragment() {
    private lateinit var binding: FragmentViewPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPagerBinding.inflate(inflater, container, false)

        val fragmentlist = arrayListOf(
            ScreenOne(),
            ScreenTwo(),
            ScreenThree(),
            ScreenFour()
        )

        val adapter = ViewPagerAdapter(
            fragmentlist,
            requireActivity().supportFragmentManager,
            lifecycle
        )


        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab, position -> }.attach()
        return binding.root
    }
}