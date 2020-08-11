package com.sohailshrestha.project_initializer_dagger2_room_retorfit.di.component

import android.app.Application
import com.sohailshrestha.project_initializer_dagger2_room_retorfit.data.local.prefs.PrefrenceHelperProviderModule
import com.sohailshrestha.project_initializer_dagger2_room_retorfit.data.local.room.AppDatabaseProviderModule
import com.sohailshrestha.project_initializer_dagger2_room_retorfit.data.local.source.LocalDataSourceProviderModule
import com.sohailshrestha.project_initializer_dagger2_room_retorfit.data.remote.retrofit.AppApiProviderModule
import com.sohailshrestha.project_initializer_dagger2_room_retorfit.data.remote.source.RemoteDataSourceProviderModule
import com.sohailshrestha.project_initializer_dagger2_room_retorfit.presenter.activity.mainactivity.MainActivityInjectorModule
import com.sohailshrestha.project_initializer_dagger2_room_retorfit.presenter.application.ApplicationModule
import com.sohailshrestha.project_initializer_dagger2_room_retorfit.presenter.application.MyApplication
import com.sohailshrestha.project_initializer_dagger2_room_retorfit.repository.RepositoryProviderModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

/*
*Created by Sohail Shrestha on 8/11/2020
*/
@Singleton
@Component(
    modules = [
    MainActivityInjectorModule::class,
    AndroidInjectionModule::class,
    RepositoryProviderModule::class,
    LocalDataSourceProviderModule::class,
    RemoteDataSourceProviderModule::class,
    AppApiProviderModule::class,
    AppDatabaseProviderModule::class,
    PrefrenceHelperProviderModule::class,
    ApplicationModule::class
    ]
)
interface ApplicationComponent: AndroidInjector<MyApplication> {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun bindApplicationComponentBuilder(app: Application): ApplicationComponent.Builder
        fun buildApplicationComponent(): ApplicationComponent
    }

}