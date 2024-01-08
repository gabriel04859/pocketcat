package com.gabsa.pocketcat.data.api

import com.gabsa.pocketcat.BuildConfig
import com.gabsa.pocketcat.data.model.CatDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface CatsApi {

    companion object {
        const val BASE_URL = "https://api.thecatapi.com/v1/images/"
    }

    @GET("search")
    suspend fun getCatsList(
        @Query("api_key") apiKey: String? = BuildConfig.API_KEY,
        @Query("limit") limit: Int = 15,
        @Query("has_breeds") hasBreed: Int = 1
    ): List<CatDTO>
}
