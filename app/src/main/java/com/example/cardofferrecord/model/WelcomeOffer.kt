package com.example.cardofferrecord.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "welcome_offer_tbl")
data class WelcomeOffer(

    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "card_application_id")
    val cardApplicationId: String,

    @ColumnInfo(name = "provider")
    var provider: String,

    @ColumnInfo(name = "offer_date_from")
    var offerDateFrom: Date,

    @ColumnInfo(name = "offer_date_to")
    var offerDateTo: Date,

    @ColumnInfo(name = "offer_detail")
    var offerDetail: String,

    @ColumnInfo(name = "spending_condition")
    var spendingCondition: String,

    @ColumnInfo(name = "period_condition")
    var periodCondition: String,

    @ColumnInfo(name = "fulfillment_date")
    var fulfillmentDate: Date
)
