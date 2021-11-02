package com.jinncyapps.authenapp.activities.facility.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jinncyapps.authenapp.R
import com.jinncyapps.authenapp.activities.elicitation.fragments.ClientAdapter
import com.jinncyapps.authenapp.data.ClientViewModel
import com.jinncyapps.authenapp.databinding.FragmentFacilityBinding


class FacilityFragment : Fragment() {
    private lateinit var binding: FragmentFacilityBinding
    private lateinit var mClientViewModel: ClientViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_facility, container, false)

        mClientViewModel = ViewModelProvider(this).get(ClientViewModel::class.java)

        //recyclerview
        val adapter = FacilityAdapter()
        val facilityRecyclerView = binding.rvFacilityRecyclerview
        facilityRecyclerView.adapter = adapter
        facilityRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        //viewmodel
        mClientViewModel.readAllClient.observe(viewLifecycleOwner, Observer { client ->
            adapter.setData(client)
        })

//        setHasOptionsMenu(true)

        return binding.root
    }

//    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater): Boolean {
//        inflater.inflate(R.menu.search_menu, menu)
//
//        val search = menu?.findItem(R.id.menu_search)
//        val searchView = search?.actionView as? SearchView
//        searchView?.isSubmitButtonEnabled = true
//        searchView?.setOnQueryTextListener(this)
//
//        return true
//    }
//
//    override fun onQueryTextSubmit(query: String?): Boolean {
//        TODO("Not yet implemented")
//    }
//
//    override fun onQueryTextChange(newText: String?): Boolean {
//        TODO("Not yet implemented")
//    }

}