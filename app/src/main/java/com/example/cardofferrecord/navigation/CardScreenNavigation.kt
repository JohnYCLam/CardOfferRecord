package com.example.cardofferrecord.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cardofferrecord.screens.cardadd.CardAddScreen
import com.example.cardofferrecord.screens.cardhome.CardHomeScreen
import com.example.cardofferrecord.screens.cardupdate.CardUpdateScreen

@Composable
fun CardScreenNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = CardScreen.CardHomeScreen.name) {
        composable(CardScreen.CardHomeScreen.name) {
            CardHomeScreen(navController = navController)
        }

        composable(CardScreen.CardAddScreen.name) {
            CardAddScreen(navController = navController)
        }

        composable(CardScreen.CardUpdateScreen.name) {
            CardUpdateScreen(navController = navController)
        }
    }
}