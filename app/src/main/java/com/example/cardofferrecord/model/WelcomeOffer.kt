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
    val provider: String,

    @ColumnInfo(name = "offer_date_from")
    val offerDateFrom: Date,

    @ColumnInfo(name = "offer_date_to")
    val offerDateTo: Date,

    @ColumnInfo(name = "offer_detail")
    val offerDetail: String,

    @ColumnInfo(name = "spending_condition")
    val spendingCondition: String,

    @ColumnInfo(name = "period_condition")
    val periodCondition: String,

    @ColumnInfo(name = "fulfillment_date")
    val fulfillmentDate: Date
)
