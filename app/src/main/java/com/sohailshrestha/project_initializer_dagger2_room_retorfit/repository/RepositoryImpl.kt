package com.sohailshrestha.project_initializer_dagger2_room_retorfit.repository

import com.sohailshrestha.project_initializer_dagger2_room_retorfit.data.remote.source.RemoteDataSource
import com.sohailshrestha.services.data.local.LocalDataSource

/*
*Created by Sohail Shrestha on 8/11/2020 20
*/class RepositoryImpl(private val loaclDataSource: LocalDataSource, private val remoteDataSource: RemoteDataSource):Repository {
}