package com.example.jetpackcompose

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
    MessageList(messages)
}

@Composable
fun MessageList(messages: List<MessageList>) {
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        itemsIndexed(messages) { index, message ->
            MessageRow(message, index)
        }
    }
}

@Composable
fun MessageRow(message: MessageList, count: Int) {
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
    ) {
        SetData(
            message = message,
            count = count
        )
    }
}

@Composable
fun SetData(message: MessageList, count: Int) {
    var isExpanded by remember { mutableStateOf(false) }
    Row(
        Modifier
            .fillMaxSize()
            .clickable { isExpanded = !isExpanded }
    )
    {
        Column(
            Modifier
                .padding(5.dp)
                .weight(1f),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = message.author + count, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.padding(2.dp))
            Text(
                text = message.body + count,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                /*.background(surfaceColor)*/,
                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                style = MaterialTheme.typography.body2
            )
        }
        //w(
        //  Modifier
        //      .padding(5.dp)
        //      .weight(1f),
        //  verticalAlignment = Alignment.CenterVertically,
        //  horizontalArrangement = Arrangement.End
        //{
        //  Image(
        //      painter = painterResource(R.drawable.ic_email),
        //      contentDescription = null
        //  )
        //

         Image(                                             
             painter = painterResource(R.drawable.ic_email),
             contentDescription = null  ,
             modifier = Modifier.weight(1f)
               
         )




    }
}


@Preview(showBackground = true)
@Composable
fun displayView() {
    MessageRow(message = MessageList("Android", "Testing"), 1)
}