package com.example.myapplication.data.kitties

import com.example.myapplication.data.kitties.api.KittyAPI
import com.example.myapplication.data.kitties.api.KittyAPIProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class KittyAPIRepository(kittyAPIProvider: KittyAPIProvider) : KittiesRepository {
    private val kittyAPI: KittyAPI = kittyAPIProvider.getAPI()

    override suspend fun listKitties(): List<Kitty> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchRandomKitty(): Kitty {
        val apiKittyResponse = kittyAPI.fetchRandom()
        if (!apiKittyResponse.isSuccessful) {
            throw Exception("Not Found")
        }

        return apiKittyResponse.body()!!.first().toKitty()
    }
}