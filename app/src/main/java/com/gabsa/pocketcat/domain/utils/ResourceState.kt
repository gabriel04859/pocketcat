package com.gabsa.pocketcat.domain.utils

sealed class ResourceState<out T> {
    data class Success<T>(val data: T?): ResourceState<T>()
    data class Failure(val errorException: Exception): ResourceState<Nothing>()
}
