package com.sohailshrestha.services.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sohailshrestha.project_initializer_dagger2_room_retorfit.utils.doNothing
import com.sohailshrestha.services.data.local.dao.UserDataDao
import com.sohailshrestha.services.data.local.entity.UserData


/*
*Created by Sohail Shrestha on 6/10/2020 11
*/

@Database(entities = [UserData::class],version = 1,exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getUserDataDao(): UserDataDao

    companion object{
        private lateinit var  context: Context
        private var ROOM_INSTANCE : AppDatabase? = null

        fun getInstance(context: Context):AppDatabase{
            when(ROOM_INSTANCE){
                null -> ROOM_INSTANCE = Room.databaseBuilder(context.applicationContext,AppDatabase::class.java, "app.db")
                    .fallbackToDestructiveMigration()
                    .build()
                else -> doNothing()
            }
            return ROOM_INSTANCE!!


        }
    }
}