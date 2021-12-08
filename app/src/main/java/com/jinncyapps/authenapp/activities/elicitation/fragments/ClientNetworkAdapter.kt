package com.jinncyapps.authenapp.activities.elicitation.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jinncyapps.authenapp.databinding.FragmentPartnerListBinding
import com.jinncyapps.authenapp.databinding.PartnerListItemBinding
import com.jinncyapps.authenapp.network.CdacsamPropery
import com.jinncyapps.authenapp.utils.ClientDiffUtil

class ClientNetworkAdapter: RecyclerView.Adapter<ClientNetworkAdapter.CdacsamPropertyViewHolder>() {

    private var clients = emptyList<CdacsamPropery>()

    class CdacsamPropertyViewHolder(private val binding: PartnerListItemBinding):
        RecyclerView.ViewHolder(binding.root) {

            fun bind(currentClient: CdacsamPropery){
                binding.client = currentClient
                binding.executePendingBindings()
            }

            companion object{
                fun from(parent: ViewGroup): CdacsamPropertyViewHolder{
                    val layoutInflater = LayoutInflater.from(parent.context)
                    val binding = PartnerListItemBinding.inflate(layoutInflater,parent,false)
                    return CdacsamPropertyViewHolder(binding)
                }
            }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CdacsamPropertyViewHolder {
        return CdacsamPropertyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CdacsamPropertyViewHolder, position: Int) {
        val currentClient = clients[position]
        holder.bind(currentClient)
    }

    override fun getItemCount(): Int {
        return clients.size
    }

    fun setData(newClient: List<CdacsamPropery>){
        val clientDiffUtil = ClientDiffUtil(newClient, clients)
        val clientDiffResult = DiffUtil.calculateDiff(clientDiffUtil)
        clients = newClient
        clientDiffResult.dispatchUpdatesTo(this)
    }
}