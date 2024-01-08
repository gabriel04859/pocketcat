package com.gabsa.pocketcat.domain.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

inline fun <T> makeFlowResult(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    crossinline request: suspend () -> T
): Flow<ResourceState<T>> {
    return channelFlow {
        try {
            val result = request.invoke()
            send(ResourceState.Success(result))
        } catch (exception: Exception) {
            send(ResourceState.Failure(exception))
        } catch (exception: IOException) {
            send(ResourceState.Failure(exception))
        }
    }.flowOn(dispatcher)
}