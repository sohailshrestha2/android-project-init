package com.sohailshrestha.project_initializer_dagger2_room_retorfit.data.local.room

import android.content.Context
import com.sohailshrestha.services.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/*
*Created by Sohail Shrestha on 8/11/2020 20
*/
@Module
class AppDatabaseProviderModule {
    @Provides
    @Singleton
    fun appDatabaseProvider(context: Context):AppDatabase = AppDatabase.getInstance(context)

}