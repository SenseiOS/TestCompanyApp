package com.example.testcompanyapp.retrofit

import com.example.testcompanyapp.data.Items
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET("categories?action=list")
    suspend fun getSomeData(): Response<Items>
}