package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme

class RecyclerviewActivity : ComponentActivity() {
    var messageList: ArrayList<MessageList>?= ArrayList<MessageList>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    for (i in 1..100) {
                        messageList!!.add(MessageList("Android", "Testingnmddmnf,\ndnsfksadadadadadalsdnfklsdjflksjfklsjflsj"))

                    }
                  AddList(messageList!!)
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    JetPackComposeTheme {
        Greeting2("Android")
    }
}