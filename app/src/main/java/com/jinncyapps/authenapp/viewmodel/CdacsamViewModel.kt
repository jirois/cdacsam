package com.jinncyapps.authenapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jinncyapps.authenapp.network.CdacsamApi
import kotlinx.coroutines.launch

class CdacsamViewModel: ViewModel() {
    private var _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    init {
        cdacsamApiService()
    }

    fun cdacsamApiService(){
        viewModelScope.launch {
            try {
                val linelist = CdacsamApi.retrofitService.getPropertites()
                _response.value = "Success: ${linelist.size} clients retrieved"
            } catch (e: Exception){
                _response.value = "Failure: ${e.message}"
            }

        }
    }
}