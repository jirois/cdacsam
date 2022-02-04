package com.jinncyapps.authenapp.utils

import android.Manifest
import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import com.jinncyapps.authenapp.utils.Constants.PERMISSION_LOCATION_REQUEST_CODE
import com.vmadalin.easypermissions.EasyPermissions

object Permissions {
    fun hasLocationPermission(context: Context) =
        EasyPermissions.hasPermissions(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        )

    fun requestLocationPermission(activity: Activity){
        EasyPermissions.requestPermissions(
            activity,
            "This application can not work without location permission",
            PERMISSION_LOCATION_REQUEST_CODE,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
    }
}