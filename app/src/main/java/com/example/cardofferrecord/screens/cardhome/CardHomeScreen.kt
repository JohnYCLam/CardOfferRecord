package com.example.cardofferrecord.screens.cardhome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.cardofferrecord.R

@Composable
fun CardHomeScreen(navController: NavController) {
    
    Scaffold(
        topBar = { TopAppBar() {

        }},
        floatingActionButton = { FloatingActionButton(onClick = { /*TODO*/ }) {
            
        }}
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
                        .width(300.dp)
                        .padding(top = 30.dp, bottom = 5.dp, start = 5.dp, end = 5.dp)
                        .clip(shape = RoundedCornerShape(20.dp)),
                    //alignment = Alignment.BottomCenter
                )

                Text(
                    text = "DBS BlackWorld MasterCard",
                    style = MaterialTheme.typography.subtitle1
                )

                Column(horizontalAlignment = Alignment.Start) {
                    Text(text = "Bank: DBS Bank (Hong Kong) Limited")
                    Text(text = "Application Date: Sep 1, 2022")
                    Text(text = "Approval Date: Sep 15, 2022")

                }

            }
        }
    }
}