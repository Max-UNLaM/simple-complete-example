package com.example.myapplication.data.kitties.api

import retrofit2.Response
import retrofit2.http.GET

interface KittyAPI {
    @GET("images/search")
    suspend fun fetchRandom(): Response<List<ApiKittyModel>>
}