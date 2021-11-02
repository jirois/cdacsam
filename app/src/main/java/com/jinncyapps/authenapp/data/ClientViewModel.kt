package com.jinncyapps.authenapp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClientViewModel(application: Application): AndroidViewModel(application) {
    val readAllClient: LiveData<List<Client>>
    private val repository: Repository

    init {
        val clientDao = ClientDatabase.getClientData(application).clientDao()
        readAllClient = clientDao.readAllClient()
        repository = Repository(clientDao)
    }

    fun addClient(client: Client){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addClient(client)
        }
    }

    fun deletClient(client: Client){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleClient(client)
        }
    }

}