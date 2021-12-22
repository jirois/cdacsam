package com.jinncyapps.authenapp.activities.elicitation.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jinncyapps.authenapp.network.CdacsamApi
import com.jinncyapps.authenapp.network.CdacsamPropery
import kotlinx.coroutines.launch
import java.lang.Exception

enum class ClientNetworkStatus{
    LOADING,
    DONE,
    ERROR
}

class ClientNetworkViewModel: ViewModel() {

    private var _property = MutableLiveData<List<CdacsamPropery>>()
    val property: LiveData<List<CdacsamPropery>>
        get() = _property

    private var _status = MutableLiveData<ClientNetworkStatus>()
    val status: LiveData<ClientNetworkStatus>
        get() = _status


    init {
        getCdasamProperty()
    }

    private fun getCdasamProperty(){
        viewModelScope.launch {
            _status.value = ClientNetworkStatus.LOADING
            try {
                _status.value = ClientNetworkStatus.DONE
                _property.value = CdacsamApi.retrofitService.getPropertites()


            }catch (e: Exception){
                _status.value = ClientNetworkStatus.ERROR
                _property.value = ArrayList()

            }
        }

    }
}