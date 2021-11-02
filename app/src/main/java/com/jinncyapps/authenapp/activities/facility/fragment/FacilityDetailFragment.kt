package com.jinncyapps.authenapp.activities.facility.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.jinncyapps.authenapp.R
import com.jinncyapps.authenapp.data.ClientViewModel
import com.jinncyapps.authenapp.databinding.FragmentFacilityDetailBinding


class FacilityDetailFragment : Fragment() {
  private val args by navArgs<FacilityDetailFragmentArgs>()
    private lateinit var binding: FragmentFacilityDetailBinding
    private lateinit var mClientViewModel: ClientViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_facility_detail, container, false)


        binding.tvFacilityDetailAddress.setText(args.currentClient.facility_address)

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            deleteClient()
        }
        return super.onOptionsItemSelected(item)
    }


    private fun deleteClient() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_, _ ->
            mClientViewModel.deletClient(args.currentClient)
            Toast.makeText(requireContext(),
                "Successfully removed: ${args.currentClient.facility_name}",
                Toast.LENGTH_LONG
            ).show()
            findNavController().navigate(R.id.action_facilityDetailFragment_to_facilityFragment)
        }
        builder.setNegativeButton("No"){_, _ ->}
        builder.setTitle("Delete ${args.currentClient.facility_name}")
        builder.setMessage("Are you sure you want to delete ${args.currentClient.facility_name}")
        builder.create().show()

    }

}