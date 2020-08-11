package com.sohailshrestha.services.data.local.dao

import android.app.VoiceInteractor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sohailshrestha.services.data.local.entity.UserData
import io.reactivex.Single

/*
*Created by Sohail Shrestha on 6/10/2020 11
*/

@Dao
interface UserDataDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE,entity = UserData::class)
    fun addUserData(vararg user: UserData)

    @Query("SELECT * FROM user_data LIMIT 1")
    fun getUserData(): Single<UserData>

    @Query("Delete From user_data")
    fun deleteAllUserData()
}