package com.sohailshrestha.project_initializer_dagger2_room_retorfit.repository

import com.sohailshrestha.project_initializer_dagger2_room_retorfit.data.remote.source.RemoteDataSource
import com.sohailshrestha.services.data.local.LocalDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/*
*Created by Sohail Shrestha on 8/11/2020 20
*/
@Module
class RepositoryProviderModule {
    @Provides
    @Singleton
    fun providesRepository(localDataSource: LocalDataSource, remoteDataSource: RemoteDataSource): Repository = RepositoryImpl(localDataSource, remoteDataSource)
}