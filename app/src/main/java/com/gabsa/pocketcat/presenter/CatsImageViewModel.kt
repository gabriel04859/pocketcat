package com.gabsa.pocketcat.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gabsa.pocketcat.data.model.CatDTO
import com.gabsa.pocketcat.presenter.usecases.CatsImageUseCase
import com.gabsa.pocketcat.presenter.utils.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CatsImageViewModel(private val useCase: CatsImageUseCase): ViewModel() {
    private val _catList = MutableStateFlow<UiState<List<CatDTO>>>(UiState.InitState)
    val catList: StateFlow<UiState<List<CatDTO>>> get() = _catList

    fun getCatList(limit: Int = 10) {
        viewModelScope.launch {
            useCase.invoke(limit).collect { state ->
                _catList.value = state
            }
        }
    }
}