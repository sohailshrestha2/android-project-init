package com.sohailshrestha.project_initializer_dagger2_room_retorfit.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import java.util.prefs.Preferences
import javax.inject.Singleton

/*
*Created by Sohail Shrestha on 8/11/2020 20
*/
@Module
class PrefrenceHelperProviderModule {
    private val PREFRENCE = "app_prefrences"

    @Singleton
    @Provides
    fun sharedPrefrenceProvider(context: Context): SharedPreferences{
        return context.getSharedPreferences(PREFRENCE,Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun preferenceHelper(sharedPreferences: SharedPreferences):PrefrenceHelper = PrefrenceHelper(sharedPreferences)
}