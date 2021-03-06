package com.sohailshrestha.project_initializer_dagger2_room_retorfit.data.remote.source

import com.sohailshrestha.project_initializer_dagger2_room_retorfit.data.remote.retrofit.AppApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/*
*Created by Sohail Shrestha on 8/11/2020 20
*/
@Module
class RemoteDataSourceProviderModule {
    @Provides
    @Singleton
    fun provideAppRemoteDataSource(appApi: AppApi):RemoteDataSource = RemoteDataSourceImpl(appApi)

}