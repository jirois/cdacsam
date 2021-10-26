package com.jinncyapps.authenapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "client_table")
data class Client (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val address: String,
    val phone: String,
    val clientId: String,
    val elicit_name: String,
    val elicit_address: String,
    val elicit_phone: String,
    val elicit_lat: Double,
    val elicit_lng: Double,
    val facility_name: String,
    val facility_address: String,
    val cam_team_name: String

    )