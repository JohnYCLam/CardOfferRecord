package com.example.cardofferrecord.model

data class ThirdPartyWelcomeOffer(
    val provider: String,
    val offerDateFrom: Int,
    val offerDateTo: Int,
    val offerDetail: String,
    val spendingCondition: String,
    val periodCondition: String
)
