package com.example.cardofferrecord.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "card_application_info_tbl")
data class CardApplicationInfo(
    @PrimaryKey
    val id: String,

    @ColumnInfo(name = "card_image_id")
    var cardImageId: Int,

    @ColumnInfo(name = "card_name")
    var cardName: String,

    @ColumnInfo(name = "card_bank")
    var cardBank: String,

    @ColumnInfo(name = "application_date")
    var applicationDate: Date,

    @ColumnInfo(name = "approval_date")
    var approvalDate: Date


)
