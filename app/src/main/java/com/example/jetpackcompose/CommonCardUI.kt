package com.example.jetpackcompose


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@ExperimentalFoundationApi
@Composable
fun CommonCard(list: ProductCategoryItem) {
    Box(
        modifier = Modifier
            .padding(5.dp)
    ) {
        CommonCardBody(list)
    }
}


@ExperimentalFoundationApi
@Composable
fun CommonCardBody(list: ProductCategoryItem, color: Color = Color.White) {

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


@Composable
fun CommonSimpleCard(list: ProductItem) {
    Box(
        modifier = Modifier
            .padding(5.dp)
    ) {
        CommonUIBody(list)
    }
}

@Composable
fun CommonUIBody(list: ProductItem) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .fillMaxWidth(),
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_fb),
                    contentDescription = null
                )
                Text(
                    text = list.title,
                    style = MaterialTheme.typography.h1,
                    color = Color.Black,
                    fontSize = 12.sp,
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight()
                )
                Image(
                    painter = painterResource(R.drawable.ic_fb),
                    contentDescription = null,
                    modifier = Modifier.weight(1f),
                    alignment = CenterEnd
                )
            }

        }
    }
}
