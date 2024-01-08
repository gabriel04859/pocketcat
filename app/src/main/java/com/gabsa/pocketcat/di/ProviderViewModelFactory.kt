package com.gabsa.pocketcat.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class ProviderViewModelFactory<T: ViewModel>(private val viewModel: T): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(viewModel.javaClass)) {
            return viewModel as T
        }
        throw    throw IllegalArgumentException("Unknown class")
    }
}