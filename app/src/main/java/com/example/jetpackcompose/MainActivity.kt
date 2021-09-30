package com.example.jetpackcompose

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme
import java.lang.Math.abs

class MainActivity : ComponentActivity() {

    var messageList: ArrayList<MessageList>?= ArrayList<MessageList>()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val windows = this.window
//        windows.statusBarColor = Color.WHITE
        windows.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MODE_CHANGED)
        setContent {
            JetPackComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LoginPage(this@MainActivity)   //1

                   /* for (i in 1..100) {
                        messageList!!.add(MessageList("Android", "Testing"))
                    }
                    AddList(messageList!!) */  //2

//                    HomeScreen()  //3
                }
            }
        }
    }
}

data class MessageList(val author: String, val body: String)

data class Feature(
    val title: String,
    @DrawableRes val iconId: Int,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color
)

data class BottomMenuContent(
    val title: String,
    @DrawableRes val iconId: Int
)
