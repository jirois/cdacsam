package com.jinncyapps.authenapp.activities.elicitation.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.jinncyapps.authenapp.R
import com.jinncyapps.authenapp.data.Client

class ClientAdapter: RecyclerView.Adapter<ClientAdapter.ClientViewHolder>() {

    private var clientList = emptyList<Client>()

    class ClientViewHolder(viewItem: View): RecyclerView.ViewHolder(viewItem) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        return ClientViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.partner_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
       val currentClient = clientList[position]

//        holder.itemView.findViewById<TextView>(R.id.tv_facility_name).text = currentClient.name
//        holder.itemView.findViewById<TextView>(R.id.tv_client_id_no).text = currentClient.clientId
//        holder.itemView.findViewById<TextView>(R.id.tv_facility_phone).text = currentClient.facility_name

        holder.itemView.findViewById<View>(R.id.elicit_list_detail).setOnClickListener {
            val action = PartnerListFragmentDirections.actionPartnerListFragmentToElicitClientDetails2(currentClient)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return clientList.size
    }

    fun setData(client: List<Client>){
        this.clientList = client
        notifyDataSetChanged()
    }


}