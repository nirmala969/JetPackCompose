package com.example.jetpackcompose

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.example.jetpackcompose.ui.theme.JetPackComposeTheme

class MainActivity : ComponentActivity() {

    var messageList: ArrayList<MessageList>? = ArrayList<MessageList>()

    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val windows = this.window
//        windows.statusBarColor = Color.WHITE
        windows.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MODE_CHANGED)
        setContent {
            JetPackComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
//                    LoginPage(this@MainActivity)   //1

                    /* for (i in 1..100) {
                         messageList!!.add(MessageList("Android", "Testing"))
                     }
                     AddList(messageList!!) */  //2

//                    HomeScreen()  //3
                    val viewType = listOf("1", "2", "3", "4", "5", "6")
/*
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(5.dp)
                    ) {
                        item {
                            val transferMoneylist = ArrayList<ProductItem>()
                            for (i in 1..4) {
                                transferMoneylist.add(
                                    ProductItem(
                                        "title $i",
                                        R.drawable.ic_fb
                                    )
                                )
                            }
                            val transferMoney =
                                ProductCategoryItem(transferMoneylist, "Transfer Money")
                            CommonCard(transferMoney)
                        }
                        item {
                            val sendToFrndList = ArrayList<ProductItem>()
                            for (i in 1..4) {
                                sendToFrndList.add(ProductItem("title $i", R.drawable.ic_fb))
                            }
                            val sendToFrnd = ProductCategoryItem(sendToFrndList, "Send to friends")
                            CommonCard(sendToFrnd)
                        }
                        item {
                            val payBill = ArrayList<ProductItem>()
                            for (i in 1..8) {
                                payBill.add(ProductItem("title $i", R.drawable.ic_fb))
                            }
                            val payBillList = ProductCategoryItem(payBill, "Pay Bills")
                            PayBills(payBillList)
                        }
                        item {
                            val covisList = ArrayList<ProductItem>()
                            for (i in 1..2) {
                                covisList.add(ProductItem("title $i", R.drawable.ic_fb))
                            }
                            val covidData = ProductCategoryItem(covisList, "Covid Support")
                            CommonCard(covidData)
                        }
                        item {
                            val covisList = ArrayList<ProductItem>()
                            for (i in 1..2) {
                                covisList.add(ProductItem("title $i", R.drawable.ic_fb))
                            }
                            val covidData = ProductCategoryItem(covisList, "Covid Support")
                            CommonCard(covidData)
                        }
                        item {
                            val bannerList = ArrayList<ProductItem>()
                            for (i in 1..4) {
                                bannerList.add(
                                    ProductItem(
                                        "title $i",
                                        R.drawable.ic_launcher_background
                                    )
                                )
                            }
                            val banner = ProductCategoryItem(bannerList, "Banner")
                            BannerCompose(banner)
                        }
                    }
                }*/


//                     val scrollState = rememberScrollState()
                    Column(
                        modifier = Modifier
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        Color.Cyan,
                                        Color.Magenta,
                                        Color.White,
                                        Color.Cyan
                                    )
                                )
                            )
                            .fillMaxSize()
                    )
                    {
                        val transferMoneylist = ArrayList<ProductItem>()
                        for (i in 1..4) {
                            transferMoneylist.add(ProductItem("title $i", R.drawable.ic_fb))
                        }
                        val transferMoney = ProductCategoryItem(transferMoneylist, "Transfer Money")
                        TransferMoney(transferMoney)

                        val sendToFrndList = ArrayList<ProductItem>()
                        for (i in 1..4) {
                            sendToFrndList.add(ProductItem("title $i", R.drawable.ic_fb))
                        }
                        val sendToFrnd = ProductCategoryItem(sendToFrndList, "Send to friends")
                        CommonCard(sendToFrnd)

                        CheckBalanceCompose()

                        val list =
                            ProductItem(
                                "title 1",
                                R.drawable.ic_launcher_background
                            )
                        CommonSimpleCard(list)

                        val list2 =
                            ProductItem(
                                "title 1",
                                R.drawable.ic_launcher_background
                            )
                        CommonSimpleCard(list2)

                        val payBill = ArrayList<ProductItem>()
                        for (i in 1..8) {
                            payBill.add(ProductItem("title $i", R.drawable.ic_fb))
                        }
                        val payBillList = ProductCategoryItem(payBill, "Pay Bills")
                        PayBills(payBillList)

                        val covisList = ArrayList<ProductItem>()
                        for (i in 1..2) {
                            covisList.add(ProductItem("title $i", R.drawable.ic_fb))
                        }
                        val covidData = ProductCategoryItem(covisList, "Covid Support")
                        CommonCard(covidData)

                        val bannerList = ArrayList<ProductItem>()
                        for (i in 1..4) {
                            bannerList.add(
                                ProductItem(
                                    "title $i",
                                    R.drawable.ic_launcher_background
                                )
                            )
                        }
                        val banner = ProductCategoryItem(bannerList, "Banner")
                        BannerCompose(banner)
                    }
                }
            }
        }
    }
}

data class ProductItem(val title: String, val image: Int)
data class ProductCategoryItem(val items: ArrayList<ProductItem>, val category: String)


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
