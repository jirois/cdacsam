package com.jinncyapps.authenapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.*
import com.jinncyapps.authenapp.data.Client

@Dao
interface ClientDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addClient(client: Client)

    @Delete
    suspend fun deleteFacility(client: Client)

    @Query("SELECT * FROM client_table ORDER BY id DESC")
    fun readAllClient():LiveData<List<Client>>
}