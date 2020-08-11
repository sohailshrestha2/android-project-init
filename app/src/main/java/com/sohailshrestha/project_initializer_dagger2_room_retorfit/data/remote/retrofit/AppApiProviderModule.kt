package com.sohailshrestha.project_initializer_dagger2_room_retorfit.data.remote.retrofit

import com.sohailshrestha.project_initializer_dagger2_room_retorfit.data.local.prefs.PrefrenceHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/*
*Created by Sohail Shrestha on 8/11/2020 20
*
*
*/
@Module
class AppApiProviderModule {

    @Provides
    @Singleton
    fun providesAppApi(prefsHelper:PrefrenceHelper):AppApi = AppApi.getAppApiService(prefsHelper.authToken)
}