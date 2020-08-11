package com.sohailshrestha.project_initializer_dagger2_room_retorfit.presenter.application

import com.sohailshrestha.project_initializer_dagger2_room_retorfit.di.component.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/*
*Created by Sohail Shrestha on 8/11/2020 18
*/

class MyApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return getAndroidInjectorForMyApplication()
    }

    private fun getAndroidInjectorForMyApplication() =
        getApplicationComponentBuilder().buildApplicationComponent()

    private fun getDaggerApplicationComponentBuilder() = DaggerApplicationComponent.builder()

    private fun getApplicationComponentBuilder() =
        getDaggerApplicationComponentBuilder().bindApplicationComponentBuilder(this)


}