package com.example.myapplication.ui

import android.net.Uri
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.kitties.KittiesRepository
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import java.io.IOException

class KittiesViewModel(private val kittiesRepository: KittiesRepository) : ViewModel() {
    var kittyImageUrl =
        MutableLiveData(Uri.parse("https://cdn2.thecatapi.com/images/IOetZNghN.jpg"))
    var kittyId = MutableLiveData("1")
    var errorMessage = MutableLiveData("Error")

    init {
        randomize()
    }

    fun randomize() {
        viewModelScope.launch {
            try {
                val randomKitten = kittiesRepository.fetchRandomKitty()
                kittyImageUrl.value = Uri.parse(randomKitten.url)
                kittyId.value = randomKitten.id
            } catch (ex: java.lang.Exception) {
                errorMessage.value = ex.message
            }
        }
    }
}