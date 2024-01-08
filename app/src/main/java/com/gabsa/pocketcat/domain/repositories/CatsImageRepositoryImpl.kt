package com.gabsa.pocketcat.domain.repositories

import com.gabsa.pocketcat.data.api.CatsApi
import com.gabsa.pocketcat.data.model.CatDTO
import com.gabsa.pocketcat.domain.utils.ResourceState
import com.gabsa.pocketcat.domain.utils.makeFlowResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class CatsImageRepositoryImpl(private val api: CatsApi, private val dispatcher: CoroutineDispatcher): CatsImageRepository {

    override suspend fun getCatsList(limit: Int): Flow<ResourceState<List<CatDTO>>> {
       return makeFlowResult { api.getCatsList(limit = limit) }
    }
}