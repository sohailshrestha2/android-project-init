package com.sohailshrestha.services.data.local

import com.sohailshrestha.project_initializer_dagger2_room_retorfit.data.local.prefs.PrefrenceHelper
import com.sohailshrestha.services.data.local.dao.UserDataDao
import com.sohailshrestha.services.data.local.entity.UserData
import io.reactivex.Completable
import io.reactivex.Single
import java.lang.Exception

/*
*Created by Sohail Shrestha on 6/10/2020 11
*/

class LocalDataSourceImpl(
    private val database: AppDatabase,
    private val prefsHelper: PrefrenceHelper
) : LocalDataSource {

    private val userDataDao: UserDataDao by lazy {
        database.getUserDataDao()
    }

    override fun storeAuthToken(token: String?) {
        prefsHelper.authToken = token
    }

    override fun getAuthToken(): String? = prefsHelper.authToken

    override fun storeUserData(userData: UserData):Completable =    Completable.create{
        try {
            userDataDao.deleteAllUserData()
            userDataDao.addUserData(userData)
            it.onComplete()
        }catch (exception: Exception){
         it.onError(Throwable(exception))
        }


        }



    override fun getUserData(): Single<UserData> = userDataDao.getUserData()
}