package com.jinncyapps.authenapp.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.jinncyapps.authenapp.R
import com.jinncyapps.authenapp.activities.elicitation.ElicitationActivity
import com.jinncyapps.authenapp.data.Client
import com.jinncyapps.authenapp.data.ClientViewModel
import com.jinncyapps.authenapp.databinding.ActivityAddClientBinding

class AddClientActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddClientBinding
    private lateinit var mClientViewModel: ClientViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_add_client)
        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.purple_700)
        }

        setupActionBar()

        mClientViewModel = ViewModelProvider(this).get(ClientViewModel::class.java)

        binding.btnSave.setOnClickListener {
            addClientDataToDatabase()
        }

    }

    private fun addClientDataToDatabase() {
        val clientName:String  = binding.etClientName.text.toString().trim()
        val clientAddress:String  = binding.etClientAddress.text.toString().trim()
        val clienNumber:String  = binding.etNumber.text.toString().trim()
        val clientId:String  = binding.etClientId.text.toString().trim()
        val elicitName:String  = binding.etElicitName.text.toString().trim()
        val elicitAddress:String  = binding.etElicitAddress.text.toString().trim()
        val elicitNumber:String  = binding.etElicitNumber.text.toString().trim()
        val elicitLat:String = binding.etElicitLat.text.toString()
        val elicitLng:String = binding.etElicitLng.text.toString()
        val facilityName:String = binding.etFacilityName.text.toString()
        val facilityAddress: String = binding.etFacilityAddress.text.toString()
        val camTeam:String = binding.etCamName.text.toString()

        if (inputCheck(clientName, clientAddress, clienNumber, clientId, elicitName, elicitAddress, elicitNumber, elicitLat, elicitLng)){
            val clientData = Client(0, clientName, clientAddress, clienNumber, clientId, elicitName,
                                elicitAddress, elicitNumber, elicitLat.toDouble(), elicitLng.toDouble(),
                                facilityName, facilityAddress, camTeam)
            mClientViewModel.addClient(clientData)

            Toast.makeText(this,
                    "Client successfully added",
                Toast.LENGTH_LONG
                ).show()
            startActivity(Intent(this@AddClientActivity, ElicitationActivity::class.java))
        }else {
            Toast.makeText(this,
                "All fields must be filled out",
                Toast.LENGTH_LONG
            ).show()
        }

    }

    private fun inputCheck(name: String,
                           address: String,
                           phone: String,
                           id: String,
                           eName: String,
                           eAddress: String,
                           ePhone: String,
                           eLat: String,
                           eLng: String,
                ): Boolean{
        return (name.isNotEmpty() && address.isNotEmpty() &&
                phone.isNotEmpty() && id.isNotEmpty() && eName.isNotEmpty()
                && eAddress.isNotEmpty() && ePhone.isNotEmpty() && eLat.isNotEmpty() && eLng.isNotEmpty())
    }


    private fun setupActionBar() {

        setSupportActionBar(binding.toolbarAddclientActivity)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back)
        }
        binding.tvTitle.text = resources.getString(R.string.tv_add_client_title)

        binding.toolbarAddclientActivity.setNavigationOnClickListener { onBackPressed() }
    }
}