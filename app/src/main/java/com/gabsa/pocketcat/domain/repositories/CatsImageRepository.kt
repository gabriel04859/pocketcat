package com.gabsa.pocketcat.domain.repositories

import com.gabsa.pocketcat.data.model.CatDTO
import com.gabsa.pocketcat.domain.utils.ResourceState
import kotlinx.coroutines.flow.Flow

interface CatsImageRepository {
    suspend fun getCatsList(limit: Int): Flow<ResourceState<List<CatDTO>>>
}