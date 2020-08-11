package com.sohailshrestha.project_initializer_dagger2_room_retorfit.data.remote.retrofit

import com.sohailshrestha.project_initializer_dagger2_room_retorfit.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/*
*Created by Sohail Shrestha on 8/11/2020 18
*/
interface AppApi {



    companion object {
        fun getAppApiService(authToken: String? = null): AppApi {
            val retrofitHelper = RetrofitInstantiateHelper()
            val mApiService = retrofitHelper.getRetrofit(authToken).create(AppApi::class.java)
            return mApiService;
        }

    }
}