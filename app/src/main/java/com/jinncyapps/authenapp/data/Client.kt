package com.jinncyapps.authenapp.data

import android.os.Parcel
import android.os.Parcelable
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

    ):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(name)
        writeString(address)
        writeString(phone)
        writeString(clientId)
        writeString(elicit_name)
        writeString(elicit_address)
        writeString(elicit_phone)
        writeDouble(elicit_lat)
        writeDouble(elicit_lng)
        writeString(facility_name)
        writeString(facility_address)
        writeString(cam_team_name)
    }

    companion object CREATOR : Parcelable.Creator<Client> {
        override fun createFromParcel(parcel: Parcel): Client {
            return Client(parcel)
        }

        override fun newArray(size: Int): Array<Client?> {
            return arrayOfNulls(size)
        }
    }

}