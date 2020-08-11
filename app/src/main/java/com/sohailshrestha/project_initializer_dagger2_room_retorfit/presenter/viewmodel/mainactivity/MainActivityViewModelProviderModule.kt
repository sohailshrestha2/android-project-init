package com.sohailshrestha.project_initializer_dagger2_room_retorfit.presenter.viewmodel.mainactivity

import androidx.lifecycle.ViewModelProvider
import com.sohailshrestha.project_initializer_dagger2_room_retorfit.presenter.activity.mainactivity.MainActivity
import com.sohailshrestha.project_initializer_dagger2_room_retorfit.repository.Repository
import com.sohailshrestha.services.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

/*
*Created by Sohail Shrestha on 8/11/2020 20
*
*/
@Module
class MainActivityViewModelProviderModule {
    @Provides
    @ActivityScope
    fun mainActivityViewModelFactoryProvider(repository: Repository): MainActivityViewModelFactory = MainActivityViewModelFactory(repository)

    @Provides
    @ActivityScope
    fun mainActivityViewModelProvider(activity:MainActivity, factory: MainActivityViewModelFactory):MainActivityViewModel = ViewModelProvider(activity, factory).get(MainActivityViewModel::class.java)
}