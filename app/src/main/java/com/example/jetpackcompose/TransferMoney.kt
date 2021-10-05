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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.DeepBlue


@ExperimentalFoundationApi
@Composable
fun TransferMoney(list: ProductCategoryItem) {
    Box(
        modifier = Modifier
            .padding(5.dp)
    ) {

        TransferMoneyBody(list)
    }
}


@ExperimentalFoundationApi
@Composable
fun TransferMoneyBody(list: ProductCategoryItem, color: Color = Color.White) {
Row() {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        ) {
            Text(
                text = list.category,
                style = MaterialTheme.typography.h1,
                color = Color.Black,
                fontSize = 12.sp,
                modifier = Modifier.fillMaxWidth()
            )

            LazyVerticalGrid(
                cells = GridCells.Fixed(4)
            ) {
                items(list.items.size) {
                    Item(category = list.items[it])
                }
            }
        }
        Text(
            text = "Approve Pending Request",
            style = MaterialTheme.typography.body1,
            fontSize = 12.sp,
            color = DeepBlue,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(5.dp),
            textAlign = TextAlign.Center
        )
    }
}
}