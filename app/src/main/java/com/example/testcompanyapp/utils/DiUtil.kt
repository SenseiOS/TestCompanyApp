package com.example.testcompanyapp.utils

import com.example.testcompanyapp.retrofit.RetrofitService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://burger.devforfun.net/api.php/v1/"

object DiUtil {

    private val retrofitService by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val api: RetrofitService by lazy {
        retrofitService.create(RetrofitService::class.java)
    }
}