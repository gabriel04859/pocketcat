package com.gabsa.pocketcat.presenter.usecases

import com.gabsa.pocketcat.data.model.CatDTO
import com.gabsa.pocketcat.domain.repositories.CatsImageRepository
import com.gabsa.pocketcat.domain.utils.ResourceState
import com.gabsa.pocketcat.presenter.utils.UiState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.onStart

class CatsImageUseCase(private val repository: CatsImageRepository) {

    @OptIn(ExperimentalCoroutinesApi::class)
    suspend operator fun invoke(limit: Int): Flow<UiState<List<CatDTO>>> {
        return repository.getCatsList(limit).onStart {
            UiState.Loading
        }.catch {
            UiState.Failure(it as Exception)
        }.mapLatest { state ->
            when(state) {
                is ResourceState.Failure -> UiState.Failure(state.errorException)
                is ResourceState.Success -> UiState.Success(state.data)
            }
        }
    }
}
