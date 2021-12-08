package com.jinncyapps.authenapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.jinncyapps.authenapp.network.CdacsamPropery

class ClientDiffUtil(
    private val newClient: List<CdacsamPropery>,
    private val oldClient: List<CdacsamPropery>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldClient.size
    }

    override fun getNewListSize(): Int {
        return newClient.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldClient[oldItemPosition] === newClient[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldClient[oldItemPosition] == newClient[newItemPosition]

    }
}