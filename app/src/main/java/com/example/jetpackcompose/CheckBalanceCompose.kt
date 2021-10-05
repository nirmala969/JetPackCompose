package com.example.jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CheckBalanceCompose() {
    Box(
        modifier = Modifier
            .padding(5.dp)
    ) {
        checkBalance()
    }
}

@Composable
fun checkBalance() {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .fillMaxWidth(),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_fb),
                    contentDescription = null,
                    Modifier.padding(10.dp).wrapContentWidth()
                )
                Column() {
                    Text(
                        text = "UserName@gmail",
                        style = MaterialTheme.typography.h1,
                        color = Color.Black,
                        fontSize = 12.sp,
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight()
                    )
                    Text(
                        text = "ICICI Bank ***1234",
                        style = MaterialTheme.typography.body1,
                        color = Color.Gray,
                        fontSize = 11.sp,
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight()
                    )
                    Text(
                        text = "Check Balance",
                        style = MaterialTheme.typography.body1,
                        color = Color.Blue,
                        fontSize = 10.sp,
                        modifier = Modifier
                            .wrapContentWidth()
                            .wrapContentHeight()
                    )

                }

            }

        }
    }

}
