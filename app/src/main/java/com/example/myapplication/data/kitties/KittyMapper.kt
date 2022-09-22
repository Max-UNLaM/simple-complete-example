package com.example.myapplication.data.kitties

import com.example.myapplication.data.kitties.api.ApiKittyModel


fun ApiKittyModel.toKitty() = Kitty(
    id = id,
    height = height,
    width = width,
    url = url
)
