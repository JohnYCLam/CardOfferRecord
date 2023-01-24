package com.example.cardofferrecord.model

import java.util.*

data class ThirdPartyWelcomeOffer(
    val id: UUID,
    val provider: String,
    val offerDateFrom: Date,
    val offerDateTo: Date,
    val offerDetail: String,
    val spendingCondition: String,
    val periodCondition: String
)
