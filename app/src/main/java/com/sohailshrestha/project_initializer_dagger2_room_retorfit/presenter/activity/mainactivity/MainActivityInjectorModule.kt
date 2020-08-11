package com.sohailshrestha.project_initializer_dagger2_room_retorfit.presenter.activity.mainactivity

import com.sohailshrestha.project_initializer_dagger2_room_retorfit.presenter.viewmodel.mainactivity.MainActivityViewModelFactory
import com.sohailshrestha.project_initializer_dagger2_room_retorfit.presenter.viewmodel.mainactivity.MainActivityViewModelProviderModule
import com.sohailshrestha.services.di.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/*
*Created by Sohail Shrestha on 8/11/2020 20
*/
@Module
abstract class MainActivityInjectorModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityViewModelProviderModule::class])
    abstract fun setUpDepandancyInjectionInMainActivity():MainActivity
}