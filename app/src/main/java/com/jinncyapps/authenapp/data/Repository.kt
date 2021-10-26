package com.jinncyapps.authenapp.data

import androidx.lifecycle.LiveData

class Repository(private val clientDao: ClientDao) {

    val readAllClient: LiveData<List<Client>> = clientDao.readAllClient()

    suspend fun addClient(client: Client){
        clientDao.addClient(client)
    }
}