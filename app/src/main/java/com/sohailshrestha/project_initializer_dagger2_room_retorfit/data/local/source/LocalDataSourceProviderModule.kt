package com.sohailshrestha.project_initializer_dagger2_room_retorfit.data.local.source

import com.sohailshrestha.project_initializer_dagger2_room_retorfit.data.local.prefs.PrefrenceHelper
import com.sohailshrestha.services.data.local.AppDatabase
import com.sohailshrestha.services.data.local.LocalDataSource
import com.sohailshrestha.services.data.local.LocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/*
*Created by Sohail Shrestha on 8/11/2020 20
*/
@Module
class LocalDataSourceProviderModule {
    @Provides
    @Singleton
    fun provideAppLocalDataSource(
        appDatabase: AppDatabase,
        prefsHelper: PrefrenceHelper
    ): LocalDataSource = LocalDataSourceImpl(appDatabase, prefsHelper)
}