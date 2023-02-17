package com.example.myapplication.api

import com.example.myapplication.models.Data
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("/carlist")
    suspend fun getAllContent(@Query("fbclid") fbclid: String): Response<Data>
}