package com.example.androidhomework.data.service

import com.example.androidhomework.data.model.ItemsResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("/users")
    fun getData(): Single<ItemsResponse>
}