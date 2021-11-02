package com.jinncyapps.authenapp.activities.facility

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.jinncyapps.authenapp.R
import com.jinncyapps.authenapp.databinding.ActivityFacilityBinding

class FacilityActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFacilityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  DataBindingUtil.setContentView(this,R.layout.activity_facility)

        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.purple_700)
        }
//
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFacilityFragment) as NavHostFragment
//        val navController = navHostFragment.navController
//        NavigationUI.setupActionBarWithNavController(this,navController)

        setupActionBar()
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = this.findNavController(R.id.navHostFacilityFragment)
//        return navController.navigateUp()
//    }

    private fun setupActionBar() {

        setSupportActionBar(binding.toolbarFacilityActivity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }
        binding.tvTitle.text = resources.getString(R.string.tv_facility_title)

        binding.toolbarFacilityActivity.setNavigationOnClickListener { onBackPressed() }
    }
}