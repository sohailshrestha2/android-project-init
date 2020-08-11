package com.sohailshrestha.services.data.local

import com.sohailshrestha.services.data.local.entity.UserData
import io.reactivex.Completable
import io.reactivex.Single

/*
*Created by Sohail Shrestha on 6/10/2020 11
*/interface LocalDataSource {
    fun getUserData(): Single<UserData>
    fun storeUserData(userData: UserData): Completable
    fun getAuthToken(): String?
    fun storeAuthToken(token: String?)
}