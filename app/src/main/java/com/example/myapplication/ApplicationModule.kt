package com.example.myapplication

import com.example.myapplication.data.kitties.KittiesRepository
import com.example.myapplication.data.kitties.KittyAPIRepository
import com.example.myapplication.data.kitties.KittyFakeRepository
import com.example.myapplication.data.kitties.api.KittyAPIMainProvider
import com.example.myapplication.data.kitties.api.KittyAPIProvider
import com.example.myapplication.ui.KittiesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val localRepositoryModule = module {
    single<KittiesRepository> { KittyFakeRepository() }
    viewModel { KittiesViewModel(get()) }
}

val remoteRepository = module {
    single<KittyAPIProvider> { KittyAPIMainProvider() }
    single<KittiesRepository> { KittyAPIRepository(get()) }
    viewModel { KittiesViewModel(get()) }
}