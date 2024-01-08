package com.gabsa.pocketcat.di

import com.gabsa.pocketcat.presenter.usecases.CatsImageUseCase

fun providesCatListUseCase(): CatsImageUseCase = CatsImageUseCase(providesCatListRepository())