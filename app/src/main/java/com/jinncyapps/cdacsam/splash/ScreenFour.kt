package com.jinncyapps.cdacsam.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.jinncyapps.cdacsam.R
import com.jinncyapps.cdacsam.databinding.FragmentScreenFourBinding


class ScreenFour : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentScreenFourBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_screen_four, container, false)

        return binding.root
    }

}