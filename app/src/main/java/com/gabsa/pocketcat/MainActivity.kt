package com.gabsa.pocketcat

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.gabsa.pocketcat.data.model.CatDTO
import com.gabsa.pocketcat.di.providerCatsImageViewModel
import com.gabsa.pocketcat.presenter.CatsImageViewModel
import com.gabsa.pocketcat.presenter.ui.components.LazyGridColumView
import com.gabsa.pocketcat.presenter.ui.theme.PocketcatTheme
import com.gabsa.pocketcat.presenter.utils.UiState

class MainActivity : ComponentActivity() {
    private  val TAG = "MainFragment"
    private val viewModel: CatsImageViewModel by lazy { providerCatsImageViewModel() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PocketcatTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val catList by viewModel.catList.collectAsState(initial = UiState.InitState)

                    when(catList) {
                        is UiState.Failure -> Log.d(TAG, "onCreate: ${(catList as UiState.Failure).errorException}")
                        UiState.InitState -> Log.d(TAG, "onCreate: InitState}")
                        UiState.Loading -> Log.d(TAG, "onCreate: Loading")
                        is UiState.Success -> {
                            LazyGridColumView(customItemList = (catList as UiState.Success<List<CatDTO>>).data as List<CatDTO>)
                        }
                    }
                }
            }
        }
        viewModel.getCatList()
    }
}
