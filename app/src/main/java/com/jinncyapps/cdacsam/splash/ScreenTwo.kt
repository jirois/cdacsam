package com.jinncyapps.cdacsam.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.jinncyapps.cdacsam.R
import com.jinncyapps.cdacsam.databinding.FragmentScreenTwoBinding

class ScreenTwo : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding:FragmentScreenTwoBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_screen_two, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)
        binding.tvBtnContinue.setOnClickListener {
            viewPager?.currentItem = 2
        }

        return binding.root
    }

}