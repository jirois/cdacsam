package com.jinncyapps.authenapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.jinncyapps.authenapp.databinding.ActivityLandingBinding

class LandingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLandingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_landing)

        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.purple_700)
        }


        val drawerLayout = binding.drawerLayout
        val menuIcon = findViewById<ImageView>(R.id.iv_drawer_menu)
        val navView = findViewById<NavigationView>(R.id.nav_drawer)

        navView.itemIconTintList = null

        menuIcon.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

//        val navController = Navigation.findNavController(this, R.id.fragment)
//        NavigationUI.setupWithNavController(navView, navController)
//
//        val title = findViewById<TextView>(R.id.main_toolbar_title)
//        navController
//            .addOnDestinationChangedListener { controller, destination, arguments ->
//                title.text = destination.label
//            }

    }
}