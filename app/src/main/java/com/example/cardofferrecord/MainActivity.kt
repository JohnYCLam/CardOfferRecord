package com.example.cardofferrecord

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.cardofferrecord.navigation.CardScreenNavigation
import com.example.cardofferrecord.ui.theme.CardOfferRecordTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardOfferRecordTheme {
                // A surface container using the 'background' color from the theme
                CardOfferApp()
            }
        }
    }
}

@Composable
fun CardOfferApp() {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardScreenNavigation()
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CardOfferRecordTheme {
        CardOfferApp()
    }
}