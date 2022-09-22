package com.example.myapplication.data.kitties

class KittyFakeRepository : KittiesRepository {
    private val kitties = listOf(
        Kitty("1", "https://cdn2.thecatapi.com/images/IOetZNghN.jpg", "1", "2"),
        Kitty("2", "https://cdn2.thecatapi.com/images/5g4.jpg", "800", "592"),
        Kitty("akc", "https://cdn2.thecatapi.com/images/akc.jpg", "800", "592"),
        Kitty("dql", "https://cdn2.thecatapi.com/images/dql.jpg", "2448", "1836"),
        Kitty("b9i", "https://cdn2.thecatapi.com/images/b9i.jpg", "500", "602"),
        Kitty("nd9FDCrLY", "https://cdn2.thecatapi.com/images/nd9FDCrLY.jpg", "750", "937")
    )

    override suspend fun fetchRandomKitty(): Kitty {
        return kitties[(0..5).random()]
    }

    override suspend fun listKitties(): List<Kitty> {
        return kitties
    }
}