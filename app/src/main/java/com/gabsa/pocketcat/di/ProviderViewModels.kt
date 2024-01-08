package com.gabsa.pocketcat.di

import androidx.lifecycle.ViewModelProvider
import com.gabsa.pocketcat.MainActivity
import com.gabsa.pocketcat.presenter.CatsImageViewModel

fun MainActivity.providerCatsImageViewModel() = ViewModelProvider(
    this, ProviderViewModelFactory(
        CatsImageViewModel(
            providesCatListUseCase()
        )
    )
)[CatsImageViewModel::class.java]