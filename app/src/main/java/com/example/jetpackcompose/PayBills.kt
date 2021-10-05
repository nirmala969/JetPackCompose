package com.example.jetpackcompose


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.DeepBlue


@ExperimentalFoundationApi
@Composable
fun PayBills(list:ProductCategoryItem) {
    Box(
        modifier = Modifier
            .padding(5.dp)
    ) {
            PayBillBody(list)
    }
}


@ExperimentalFoundationApi
@Composable
fun PayBillBody(list: ProductCategoryItem, color: Color = Color.White) {

    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        ) {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = list.category,
                    style = MaterialTheme.typography.h1,
                    color = Color.Black,
                    fontSize = 12.sp,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "View More",
                    style = MaterialTheme.typography.h1,
                    color = Color.Blue,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Right,
                    modifier = Modifier.weight(1f)
                )
            }

            LazyVerticalGrid(
                cells = GridCells.Fixed(4)
            ) {
                items(list.items.size) {
                    Item(category = list.items[it])
                }
            }
        }
    }
}