package com.gabsa.pocketcat.presenter.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gabsa.pocketcat.data.model.CatDTO

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyGridColumView(modifier: Modifier = Modifier, customItemList: List<CatDTO>) {
    LazyVerticalStaggeredGrid(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 8.dp, end = 8.dp),
        columns = StaggeredGridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalItemSpacing = 16.dp
    ) {
        items(customItemList) { item ->
            CustomItemRow(customItem = item)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}