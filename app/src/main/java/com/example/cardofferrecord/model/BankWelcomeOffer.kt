package com.example.cardofferrecord.model

import java.util.*

data class BankWelcomeOffer(
    val id: UUID,
    val offerDateFrom: Date,
    val offerDateTo: Date,
    val offerDetail: String,
    val spendingCondition: String,
    val periodCondition: String,
    val fulfillmentDate: Date
)
