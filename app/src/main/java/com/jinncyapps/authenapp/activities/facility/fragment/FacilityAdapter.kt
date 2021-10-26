package com.jinncyapps.authenapp.activities.facility.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jinncyapps.authenapp.R
import com.jinncyapps.authenapp.data.Client

class FacilityAdapter:RecyclerView.Adapter<FacilityAdapter.FacilityViewHolder>() {

    private var facilityList = emptyList<Client>()

    class FacilityViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacilityViewHolder {
        return FacilityViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.facility_list_item,parent,false))
    }

    override fun onBindViewHolder(holder: FacilityViewHolder, position: Int) {
        val currentItem = facilityList[position]
        holder.itemView.findViewById<TextView>(R.id.tv_facility_name).text = currentItem.facility_name
        holder.itemView.findViewById<TextView>(R.id.tv_facility_address).text = currentItem.facility_address
    }

    override fun getItemCount(): Int {
        return facilityList.size
    }

    fun setData(client: List<Client>){
        this.facilityList = client
        notifyDataSetChanged()
    }
}