package com.jinncyapps.authenapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.jinncyapps.authenapp.activities.*
import com.jinncyapps.authenapp.auth.SignInActivity
import com.jinncyapps.authenapp.databinding.ActivityLandingBinding
import com.jinncyapps.authenapp.databinding.NavHeaderBinding
import com.jinncyapps.authenapp.firebase.FirestoreClass
import com.jinncyapps.authenapp.model.User
import com.jinncyapps.authenapp.utils.capitalizeString
import com.jinncyapps.authenapp.utils.getGreetingMessage
import java.util.*

class LandingActivity : BaseActivity(),NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityLandingBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var addClient: ImageView
    private lateinit var elicition: ImageView
    private lateinit var search: ImageView
    private lateinit var notification: ImageView
    private lateinit var achievement: ImageView
    private lateinit var facility: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_landing)

        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.purple_700)
        }


        FirestoreClass().signInUser(this@LandingActivity)
        drawerLayout = binding.drawerLayout
        val menuIcon = findViewById<ImageView>(R.id.iv_drawer_menu)
        val navView = findViewById<NavigationView>(R.id.nav_drawer)

        navView.itemIconTintList = null

        menuIcon.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navView.setNavigationItemSelectedListener(this)

        val greetingText = findViewById<TextView>(R.id.tv_greeting)
        greetingText.text = getGreetingMessage()



        elicition = findViewById(R.id.btn_elicitation)
        elicition.setOnClickListener { startActivity(Intent(this@LandingActivity, ElicitationActivity::class.java)) }

        addClient = findViewById(R.id.btn_add_client)
        addClient.setOnClickListener { startActivity(Intent(this@LandingActivity, AddClientActivity::class.java)) }

        notification = findViewById(R.id.btn_notification)
        notification.setOnClickListener { startActivity(Intent(this@LandingActivity, NotificationActivity::class.java)) }

        achievement = findViewById(R.id.btn_achievement)
        achievement.setOnClickListener { startActivity(Intent(this@LandingActivity, AchievementActivity::class.java)) }

        facility = findViewById(R.id.btn_facility)
        facility.setOnClickListener { startActivity(Intent(this@LandingActivity, FacilityActivity::class.java)) }




    }





    fun updateNavigationUserSuccess(user: User){
        val headerView = binding.navDrawer.getHeaderView(0)
        val username = headerView.findViewById<TextView>(R.id.nav_view_username)
        username.text = user.name

        val welcomeUsername = findViewById<TextView>(R.id.tv_welcome_name)
        welcomeUsername.text = user.name
        welcomeUsername.toString()
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.profile -> {
                Toast.makeText(
                    this@LandingActivity,
                    "Profile",
                    Toast.LENGTH_LONG
                ).show()
            }
            R.id.notification -> {
                val intent = Intent(this, NotificationActivity::class.java)
                startActivity(intent)
            }

            R.id.signOut -> {

                FirebaseAuth.getInstance().signOut()
                val intent = Intent(this, SignInActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}