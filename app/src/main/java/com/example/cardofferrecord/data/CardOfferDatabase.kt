package com.example.cardofferrecord.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cardofferrecord.model.CardApplicationInfo
import com.example.cardofferrecord.util.DateConverter
import com.example.cardofferrecord.util.UUIDConverter

@Database(entities = [CardApplicationInfo::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class CardOfferDatabase: RoomDatabase() {
    abstract fun cardOfferDao(): CardOfferDao
}