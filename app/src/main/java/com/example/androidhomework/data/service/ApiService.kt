package com.example.androidhomework.data.service

import com.example.androidhomework.data.model.ItemsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("/users")
    suspend fun getData(): Response<List<ItemsResponse>>
}