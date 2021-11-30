package com.jinncyapps.authenapp.activities.elicitation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.jinncyapps.authenapp.R
import com.jinncyapps.authenapp.databinding.FragmentElicitClientDetailsBinding

class ElicitClientDetails : Fragment(), OnMapReadyCallback {
    private val args by navArgs<ElicitClientDetailsArgs>()
    private lateinit var binding: FragmentElicitClientDetailsBinding
    private lateinit var map: GoogleMap
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_elicit_client_details, container, false)


        binding.tvName.text = args.currentClient.elicit_name
        binding.tvDesc.text = args.currentClient.elicit_address


        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)





        return binding.root

    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        val currentPos = LatLng(args.currentClient.elicit_lat, args.currentClient.elicit_lng)
        map.addMarker(MarkerOptions().position(currentPos).title("Marker in calabar"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(currentPos, 8f))

        map.uiSettings.apply {
            isZoomControlsEnabled = true
        }

    }


}