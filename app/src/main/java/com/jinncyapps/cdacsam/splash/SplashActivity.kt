package com.jinncyapps.cdacsam.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.jinncyapps.cdacsam.ui.MainActivity
import com.jinncyapps.cdacsam.R
import com.jinncyapps.cdacsam.splash.onboarding.OnboardingActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.purple_700)




        Handler().postDelayed({
            startActivity(Intent(this, OnboardingActivity::class.java))
            finish()
        }, 2500)
    }
}