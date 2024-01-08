package com.gabsa.pocketcat.di

import com.gabsa.pocketcat.data.api.ApiBuilder
import com.gabsa.pocketcat.data.api.CatsApi

fun providesApi(): CatsApi {
    return ApiBuilder.buildCatApi()
}