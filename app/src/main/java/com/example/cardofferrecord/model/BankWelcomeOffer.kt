package com.example.cardofferrecord.model

data class BankWelcomeOffer(
    val offerDateFrom: Int,
    val offerDateTo: Int,
    val offerDetail: String,
    val spendingCondition: String,
    val periodCondition: String
)
