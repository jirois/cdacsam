package com.jinncyapps.authenapp.network

import com.squareup.moshi.Json

data class CdacsamPropery(
    val id: Int,
    @Json(name = "client_id") val clientId: String,
    val facility: String,
    val age: Int,
    val sex: String,
    val address: String,
    @Json(name = "partner_state") val partnerState: String,
    @Json(name = "partner_categorization") val partnerCategorization: String,
    @Json(name = "date_partner_tested") val datePartnerTested: String,
    @Json(name = "test_results") val testResults: String,
    @Json(name = "linked_to_care") val linkToCare: Boolean,
    @Json(name = "prep_initiated") val prepIntiated: Boolean,
    val lat: Double,
    val lng: Double

)
