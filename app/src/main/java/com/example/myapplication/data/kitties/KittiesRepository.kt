package com.example.myapplication.data.kitties

interface KittiesRepository {
    suspend fun listKitties(): List<Kitty>
    suspend fun fetchRandomKitty(): Kitty
}