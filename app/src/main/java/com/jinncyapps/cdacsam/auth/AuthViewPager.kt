package com.jinncyapps.cdacsam.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.jinncyapps.cdacsam.auth.login.LoginFragment
import com.jinncyapps.cdacsam.auth.signup.SignupFragment
import com.jinncyapps.cdacsam.databinding.AuthViewpagerFragmentBinding

class AuthViewPager: Fragment() {
    private lateinit var binding: AuthViewpagerFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AuthViewpagerFragmentBinding.inflate(inflater, container, false)

        val fragmentList = arrayListOf(
            LoginFragment(),
            SignupFragment()
        )

        val adapter = AuthViewPagerAdapter(
            fragmentList,
            childFragmentManager,
            lifecycle
        )
        binding.authViewPager2.adapter = adapter
        binding.tablout2.tabGravity = TabLayout.GRAVITY_FILL
        binding.tablout2.addTab(binding.tablout2.newTab().setText("Sign In"))
        binding.tablout2.addTab(binding.tablout2.newTab().setText("Sign Up"))

        TabLayoutMediator(binding.tablout2, binding.authViewPager2){tab, position ->
            when(position){
                0 -> tab.setText("Sign In")
                1 -> tab.setText("Sign Up")
            }
        }.attach()


        return binding.root
    }
}