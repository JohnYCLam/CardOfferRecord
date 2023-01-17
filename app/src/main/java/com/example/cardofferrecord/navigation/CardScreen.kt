package com.example.cardofferrecord.navigation

enum class CardScreen {
    CardHomeScreen,
    CardUpdateScreen,
    CardAddScreen;

    companion object {
        fun fromRoute(route: String): CardScreen
        = when(route?.substringBefore("/")) {
            CardHomeScreen.name -> CardHomeScreen
            CardUpdateScreen.name -> CardUpdateScreen
            CardAddScreen.name -> CardAddScreen
            null -> CardHomeScreen
            else -> throw  IllegalArgumentException("Route $route not found")
        }
    }
}