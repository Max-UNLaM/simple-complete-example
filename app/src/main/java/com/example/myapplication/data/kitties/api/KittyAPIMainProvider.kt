package com.example.myapplication.data.kitties.api

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class KittyAPIMainProvider : KittyAPIProvider {
    override fun getAPI(): KittyAPI {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .baseUrl("https://api.thecatapi.com/v1/")
            .build()
        return retrofit.create(KittyAPI::class.java)
    }
}