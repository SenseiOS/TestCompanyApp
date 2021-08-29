package com.example.testcompanyapp.repository

import android.util.Log
import com.example.testcompanyapp.data.Data
import com.example.testcompanyapp.utils.DiUtil

object ItemsRepository {

    var items: List<Data> = listOf()
    suspend fun getItem() {
        try {
            val response = DiUtil.api.getSomeData()
            items = response.body()?.data!!.toList()
        } catch (error: Exception) {
            Log.d("Error", error.message.toString())
        }
    }
}