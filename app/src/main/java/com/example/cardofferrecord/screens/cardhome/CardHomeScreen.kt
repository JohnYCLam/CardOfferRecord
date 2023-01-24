package com.example.cardofferrecord.screens.cardhome

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.cardofferrecord.R
import com.example.cardofferrecord.navigation.CardScreen

@Composable
fun CardHomeScreen(navController: NavController) {

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar() {

            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate(CardScreen.CardAddScreen.name) }) {

            }
        }
    ) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.padding(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                Image(
                    painter = painterResource(id = R.drawable.dbs_blackworldcard),
                    contentDescription = "Card Image",
                    modifier = Modifier
                        .width(320.dp)
                        .padding(top = 30.dp, bottom = 0.dp, start = 6.dp, end = 6.dp)
                        .clip(shape = RoundedCornerShape(20.dp)),
                    //alignment = Alignment.BottomCenter
                )

                Spacer(modifier = Modifier.padding(6.dp))

                Text(
                    text = "DBS BlackWorld MasterCard",
                    style = MaterialTheme.typography.subtitle1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
                
                Spacer(modifier = Modifier.padding(6.dp))

                Column() {
                    Card(modifier = Modifier.width(300.dp),
                        border = BorderStroke(width = 1.dp, color = Color.Gray)) {

                        Column(modifier = Modifier.padding(6.dp)) {
                            Text(text = "Card Info")
                            Text(text = "Bank: DBS Bank (Hong Kong) Limited")
                            Text(text = "Application Date: Sep 1, 2022")
                            Text(text = "Approval Date: Sep 15, 2022")

                        }
                    }

                    Spacer(modifier = Modifier.padding(6.dp))

                    Card(modifier = Modifier.width(300.dp)) {

                        Column() {
                            Text(text = "3rd Party Welcome Offer")
                            Text(text = "Provider: 小斯")
                            Text(text = "Offer Date From: Aug 31, 2022")
                            Text(text = "Offer Date To: 4 Sep, 2022")
                            Text(text = "Offer Detail: HKD 1,000 Apple Gift Card")
                            Text(text = "Spending Condition: N/A")
                            Text(text = "Period Condition: N/A")
                            Text(text = "Fulfillment Date: By 31 Dec, 2022")

                        }
                    }

                    Spacer(modifier = Modifier.padding(6.dp))

                    Card(modifier = Modifier.width(300.dp)) {

                        Column() {
                            Text(text = "Bank Welcome Offer")
                            Text(text = "Offer Date From: Aug 31, 2022")
                            Text(text = "Offer Date To: 4 Sep, 2022")
                            Text(text = "Offer Detail: 10,000 miles")
                            Text(text = "Spending Condition: HKD 5,000")
                            Text(text = "Period Condition: Within 60 days")
                            Text(text = "Fulfillment Date: By 31 Dec, 2022")
                        }
                    }
                }


            }
        }
    }
}