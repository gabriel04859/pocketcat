package com.gabsa.pocketcat.presenter.utils

sealed class UiState<out T> {
    object InitState : UiState<Nothing>()
    object Loading : UiState<Nothing>()
    data class Success<T>(val data: T?) : UiState<T>()
    data class Failure(val errorException: Exception) : UiState<Nothing>()
}