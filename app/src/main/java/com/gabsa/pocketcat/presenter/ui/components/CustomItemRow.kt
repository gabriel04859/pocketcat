package com.gabsa.pocketcat.presenter.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.gabsa.pocketcat.data.model.CatDTO

@Composable
fun CustomItemRow(modifier: Modifier = Modifier, customItem: CatDTO) {

    Box(modifier = modifier.wrapContentWidth(), contentAlignment = Alignment.Center) {
        Card(
            modifier = modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            )
        ) {

            Column(
                modifier = modifier
                    .wrapContentWidth()
            ) {
                AsyncImage(
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp)),
                    model = customItem.url,
                    contentDescription = ""
                )
                Text(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    text = customItem.breeds.first().name,
                    modifier = Modifier
                        .padding(8.dp)
                        .wrapContentWidth(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    text = customItem.breeds.first().description,
                    modifier = Modifier
                        .padding(8.dp)
                        .wrapContentWidth(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
