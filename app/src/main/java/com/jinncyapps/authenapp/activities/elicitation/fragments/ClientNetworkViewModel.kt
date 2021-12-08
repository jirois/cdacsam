package com.jinncyapps.authenapp.activities.elicitation.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jinncyapps.authenapp.network.CdacsamApi
import com.jinncyapps.authenapp.network.CdacsamPropery
import kotlinx.coroutines.launch
import java.lang.Exception

class ClientNetworkViewModel: ViewModel() {

    private var _property = MutableLiveData<List<CdacsamPropery>>()
    val property: LiveData<List<CdacsamPropery>>
        get() = _property


    init {
        getCdasamProperty()
    }

    private fun getCdasamProperty(){
        viewModelScope.launch {
            try {
                _property.value = CdacsamApi.retrofitService.getPropertites()


            }catch (e: Exception){
                _property.value = ArrayList()

            }
        }

    }
}