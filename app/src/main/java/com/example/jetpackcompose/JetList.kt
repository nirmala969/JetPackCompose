package com.example.jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun AddList(messages: List<MessageList>) {
    var count by remember { mutableStateOf(0) }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        items(messages) { message ->
            MessageRow(message,count)
        }
        /* messages.forEach { message ->
             MessageRow(message)
         }*/
    }
}
/*
@Composable
fun MessageList(messages: List<MessageList>) {
    LazyColumn( contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        items(messages) { message ->
            MessageRow(message)
        }
    }
}*/

@Composable
fun MessageRow(message: MessageList,count: Int) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
    ) {
        SetData(
            message=message,
            count = count,
        )
    }
}

@Composable
fun SetData(message: MessageList,count: Int) {
    Row(
        Modifier
            .padding(5.dp)
            .fillMaxSize()
    )
    {
        Column(
            Modifier
                .padding(5.dp)
                .weight(1f), verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = message.author+count)
            Spacer(modifier = Modifier.padding(2.dp))
            Text(text = message.body+count)
        }
        Row(
            Modifier
                .padding(5.dp)
                .weight(1f), horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(R.drawable.ic_email),
                contentDescription = null
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun displayView() {
    MessageRow(message = MessageList("Android", "Testing"),1)
}