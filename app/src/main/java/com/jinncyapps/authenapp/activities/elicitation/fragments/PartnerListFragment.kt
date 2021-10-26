package com.jinncyapps.authenapp.activities.elicitation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jinncyapps.authenapp.R
import com.jinncyapps.authenapp.data.ClientViewModel
import com.jinncyapps.authenapp.databinding.FragmentPartnerListBinding


class PartnerListFragment : Fragment() {
    private lateinit var mClientViewModel: ClientViewModel
    private lateinit var binding: FragmentPartnerListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_partner_list, container, false)

        mClientViewModel = ViewModelProvider(this).get(ClientViewModel::class.java)

       //recyclerview
        val adapter = ClientAdapter()
        val partnerRecyclerView = binding.rvPartnerRecyclerview
        partnerRecyclerView.adapter = adapter
        partnerRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        //viewmodel
        mClientViewModel.readAllClient.observe(viewLifecycleOwner, Observer { client ->
            adapter.setData(client)
        })


        return binding.root



    }


}