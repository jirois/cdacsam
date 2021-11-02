package com.jinncyapps.authenapp.activities.facility.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.jinncyapps.authenapp.R
import com.jinncyapps.authenapp.data.Client

class FacilityAdapter:RecyclerView.Adapter<FacilityAdapter.FacilityViewHolder>() {

    private var facilityList = emptyList<Client>()

   

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FacilityViewHolder {
        return FacilityViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: FacilityViewHolder, position: Int) {
        val currentItem = facilityList[position]
        holder.itemView.findViewById<TextView>(R.id.tv_facility_name).text = currentItem.facility_name
        holder.itemView.findViewById<TextView>(R.id.tv_facility_address).text = currentItem.facility_address

        holder.itemView.findViewById<View>(R.id.facility_detail_layout).setOnClickListener {
            val action = FacilityFragmentDirections.actionFacilityFragmentToFacilityDetailFragment(currentItem)
            holder.itemView.findNavController().navigate(action)

        }
    }

    override fun getItemCount(): Int {
        return facilityList.size
    }

    fun setData(client: List<Client>){
        this.facilityList = client
        notifyDataSetChanged()
    }

    class FacilityViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {

        companion object {
            fun from(parent: ViewGroup): FacilityViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.facility_list_item, parent, false)
                return FacilityViewHolder(view)
            }
        }

    }


}