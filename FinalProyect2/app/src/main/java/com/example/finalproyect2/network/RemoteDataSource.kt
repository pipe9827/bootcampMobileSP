package com.example.finalproyect2.network

import com.example.finalproyect2.BuildConfig
import com.google.android.gms.common.api.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RemoteDataSource {
    companion object{
        private const val BASE_URL = "https://6w33tkx4f9.execute-api.us-east-1.amazonaws.com"
    }

    fun <Api> buildApi(
        api: Class<Api>
    ):Api{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder().also { client ->
                    if(BuildConfig.DEBUG){
                        val logging = HttpLoggingInterceptor()
                        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                        client.addInterceptor(logging)
                    }
                }.build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
}