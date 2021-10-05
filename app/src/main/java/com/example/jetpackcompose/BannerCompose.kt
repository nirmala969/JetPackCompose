package com.example.jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable()
fun BannerCompose(list: ProductCategoryItem) {
    Box(
        modifier = Modifier
            .padding(5.dp)
    ) {
            BannerData(list)
    }
}

@Composable
fun BannerData(list: ProductCategoryItem) {

    LazyRow {
        itemsIndexed(list.items) { index, message ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(Alignment.CenterVertically)
                    .padding(5.dp),
                backgroundColor = Color(0xFFFF5470),
                elevation = 8.dp,
                shape = RoundedCornerShape(16.dp)
            ) {
                Image(
                    painter = painterResource(id = list.items.get(index).image),
                    contentDescription = null,
                    Modifier
                        .size(width = 100.dp, height = 100.dp)
                        .fillMaxSize()
                )
            }
        }
    }
}