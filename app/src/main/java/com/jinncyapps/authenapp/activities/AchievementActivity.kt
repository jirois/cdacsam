package com.jinncyapps.authenapp.activities

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.jinncyapps.authenapp.R
import com.jinncyapps.authenapp.databinding.ActivityAchievementBinding
import com.jinncyapps.authenapp.viewmodel.CdacsamViewModel

class AchievementActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAchievementBinding
    private val viewModel: CdacsamViewModel by lazy {
        ViewModelProvider(this).get(CdacsamViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_achievement)

        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.purple_700)
        }

        binding.setLifecycleOwner(this)
        binding.viewmodel = viewModel

        setupActionBar()

    }


    private fun setupActionBar() {

        setSupportActionBar(binding.toolbarAchievementActivity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }
        binding.tvTitle.text = resources.getString(R.string.tv_achievement_title)

        binding.toolbarAchievementActivity.setNavigationOnClickListener { onBackPressed() }
    }
}