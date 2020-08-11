package com.sohailshrestha.project_initializer_dagger2_room_retorfit.data.local.prefs

import android.content.SharedPreferences

/*
*Created by Sohail Shrestha on 6/10/2020 11
*/

internal const val AUTH_TOKEN = "AUTH_TOKEN"
internal const val KEEP_LOGGED_IN = "KEEP_LOGGED_IN"

class PrefrenceHelper(private val sharedPrefrence: SharedPreferences) {

    var authToken: String?
        get() = sharedPrefrence.getString(AUTH_TOKEN, null) ?: ""
        set(value) = sharedPrefrence.edit().putString(AUTH_TOKEN, value).apply()

    var keepLoggedIn: Boolean?
        get() = sharedPrefrence.getBoolean(KEEP_LOGGED_IN, false)
        set(keepLoggedIn:Boolean?) = keepLoggedIn?.let {
            sharedPrefrence.edit().putBoolean(KEEP_LOGGED_IN, it).apply()
        }
            ?: sharedPrefrence.edit().putBoolean(KEEP_LOGGED_IN, false).apply()


    fun clearPrefs(){
        sharedPrefrence.edit().clear().apply()
    }
}