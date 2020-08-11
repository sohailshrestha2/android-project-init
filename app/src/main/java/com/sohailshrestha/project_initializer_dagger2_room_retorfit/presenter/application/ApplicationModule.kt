package com.sohailshrestha.project_initializer_dagger2_room_retorfit.presenter.application

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/*
*Created by Sohail Shrestha on 5/22/2020 09
*/

@Module
abstract class ApplicationModule {

    @Binds
    @Singleton
    abstract fun providesApplicationContext(application: Application): Context

}