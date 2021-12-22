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


open class PartnerListFragment : Fragment() {
//    private lateinit var mClientViewModel: ClientViewModel
    private lateinit var binding: FragmentPartnerListBinding
    private val mClientNetworkViewModel:ClientNetworkViewModel by lazy {
        ViewModelProvider(this).get(ClientNetworkViewModel::class.java)
    }
    private val mClientNetworkAdapter by lazy { ClientNetworkAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_partner_list, container, false)



        binding.viewmodel = mClientNetworkViewModel

        //viewmodel
        mClientNetworkViewModel.property.observe(viewLifecycleOwner, { client ->
            mClientNetworkAdapter.setData(client)
        })

        setUpRecyclerview()



        return binding.root

    }


    private fun setUpRecyclerview(){
        binding.recycler.adapter = mClientNetworkAdapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
    }

   open fun showShimmerEffect(){
        binding.recycler.showShimmer()
    }

    open fun hideShimmerEffect(){
        binding.recycler.hideShimmer()
    }


}