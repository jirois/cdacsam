package com.jinncyapps.authenapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Client::class], version = 2, exportSchema = false )
abstract class ClientDatabase: RoomDatabase() {

    abstract fun clientDao(): ClientDao

    companion object{
        @Volatile
        private var INSTANCE: ClientDatabase? = null

        fun getClientData(context: Context): ClientDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this){
                var instance = Room.databaseBuilder(
                    context.applicationContext,
                    ClientDatabase::class.java,
                    "client_database"
                ).build()

                INSTANCE = instance

                return instance
            }
        }

    }
}