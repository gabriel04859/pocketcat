package com.gabsa.pocketcat.di

import com.gabsa.pocketcat.domain.repositories.CatsImageRepository
import com.gabsa.pocketcat.domain.repositories.CatsImageRepositoryImpl
import kotlinx.coroutines.Dispatchers

fun providesCatListRepository(): CatsImageRepository = CatsImageRepositoryImpl(providesApi(), Dispatchers.IO)