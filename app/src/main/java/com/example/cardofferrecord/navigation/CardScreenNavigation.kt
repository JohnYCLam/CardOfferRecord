package com.example.cardofferrecord.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cardofferrecord.screens.cardadd.CardAddScreen
import com.example.cardofferrecord.screens.cardadd.CardAddScreenViewModel
import com.example.cardofferrecord.screens.cardhome.CardHomeScreen
import com.example.cardofferrecord.screens.cardhome.CardHomeScreenViewModel
import com.example.cardofferrecord.screens.cardupdate.CardUpdateScreen

@Composable
fun CardScreenNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = CardScreen.CardHomeScreen.name) {
        composable(CardScreen.CardHomeScreen.name) {
            val cardHomeScreenViewModel = hiltViewModel<CardHomeScreenViewModel>()
            CardHomeScreen(navController = navController, viewModel = cardHomeScreenViewModel)
        }

        composable(CardScreen.CardAddScreen.name) {
            val cardAddScreenViewModel = hiltViewModel<CardAddScreenViewModel>()
            CardAddScreen(navController = navController, viewModel = cardAddScreenViewModel)
        }

        composable(CardScreen.CardUpdateScreen.name) {
            CardUpdateScreen(navController = navController)
        }
    }
}