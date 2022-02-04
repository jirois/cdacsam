package com.jinncyapps.authenapp.permission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.jinncyapps.authenapp.BaseActivity
import com.jinncyapps.authenapp.LandingActivity
import com.jinncyapps.authenapp.R
import com.jinncyapps.authenapp.databinding.ActivityPermissionBinding
import com.jinncyapps.authenapp.firebase.FirestoreClass
import com.jinncyapps.authenapp.utils.Permissions.hasLocationPermission
import com.jinncyapps.authenapp.utils.Permissions.requestLocationPermission
import com.vmadalin.easypermissions.EasyPermissions
import com.vmadalin.easypermissions.dialogs.SettingsDialog

class PermissionActivity : BaseActivity(), EasyPermissions.PermissionCallbacks {
    private lateinit var binding:ActivityPermissionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_permission)



        binding.btnContinue.setOnClickListener {
            if (hasLocationPermission(this)){
                startActivity(Intent(this, LandingActivity::class.java))
            } else {
                requestLocationPermission(this)
            }
        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(
            requestCode,
            permissions,
            grantResults,
            this
        )
    }

    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        if (EasyPermissions.permissionPermanentlyDenied(this, perms[0])){
            SettingsDialog.Builder(this).build()
        } else {
            requestLocationPermission(this)
        }
    }

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        startActivity(Intent(this, LandingActivity::class.java))
    }
}