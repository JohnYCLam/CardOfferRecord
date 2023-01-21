package com.example.cardofferrecord.model

data class CardApplicationInfo(
    val cardImageId: Int,
    val cardName: String,
    val cardBank: String,
    val applicationDate: Int,
    val approvalDate: Int
)
