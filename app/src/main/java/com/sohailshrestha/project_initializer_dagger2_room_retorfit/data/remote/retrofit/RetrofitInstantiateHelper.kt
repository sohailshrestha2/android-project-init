package com.sohailshrestha.project_initializer_dagger2_room_retorfit.data.remote.retrofit

import com.sohailshrestha.project_initializer_dagger2_room_retorfit.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/*
*Created by Sohail Shrestha on 8/11/2020 19
*/class RetrofitInstantiateHelper {
    private val AUTH_PARAM_NAME = ""

    private fun getOkHttpBuilder() = OkHttpClient.Builder()

    private fun OkHttpClient.Builder.setupCallTimeout() =
        callTimeout(5, java.util.concurrent.TimeUnit.MINUTES)

    private fun OkHttpClient.Builder.setupReadTimeout() = readTimeout(5, TimeUnit.MINUTES)


    private fun checkIfAuthParamIsProvided() = (AUTH_PARAM_NAME != null || AUTH_PARAM_NAME != "")
    private fun checkIfAuthenticationTokenIsProvided(authToken: String?) =
        (authToken != null || authToken != "")

    private fun getResponseForOkhttpClient(chain: Interceptor.Chain, request: Request) =
        chain.proceed(request)

    private fun getRequest(chain: Interceptor.Chain): Request = chain.request()

    private fun getNewRequestBuilder(oldRequest: Request): Request.Builder = oldRequest.newBuilder()

    private fun Request.Builder.addAuthTokenToHeaderOfRequestBuilder(authToken: String?) =
        when (authToken) {
            null -> addHeader(AUTH_PARAM_NAME, "")
            else -> addHeader(AUTH_PARAM_NAME, authToken)
        }

    private fun OkHttpClient.Builder.setUpAuthCodeInterceptor(
        authToken: String?
    ) = addInterceptor { chain ->

        val request = getRequest(chain)
        if (checkIfAuthParamIsProvided()) {
            if (checkIfAuthenticationTokenIsProvided(authToken)) {
                val newRequestBuilder = getNewRequestBuilder(request)
                newRequestBuilder.addAuthTokenToHeaderOfRequestBuilder(authToken)
                val newRequestWithAuthToken = newRequestBuilder.build()
                return@addInterceptor getResponseForOkhttpClient(chain, newRequestWithAuthToken)
            }

        }
        val response = getResponseForOkhttpClient(chain, request)
        return@addInterceptor response
    }


    private fun getRetrofitBuilder() = Retrofit.Builder()
    private fun Retrofit.Builder.setUpBaseUrl(baseUrl: String) = baseUrl(baseUrl)
    private fun getBaseUrlFromBuildConfig() = BuildConfig.BASE_URL
    private fun Retrofit.Builder.setUpGson() = addConverterFactory(GsonConverterFactory.create())
    private fun Retrofit.Builder.setUpOkHttpClient(authToken: String?) =
        client(getOkhttpClient(authToken).build())

    private fun getOkhttpClient(authToken: String? = "") =
        getOkHttpBuilder()
            .setupCallTimeout()
            .setupReadTimeout()
            .setUpAuthCodeInterceptor(authToken)


    fun getRetrofit(authToken: String?): Retrofit {
        val baseUrl = getBaseUrlFromBuildConfig()
        return getRetrofitBuilder()
            .setUpBaseUrl(baseUrl)
            .setUpGson()
            .setUpOkHttpClient(authToken)
            .build()
    }





}