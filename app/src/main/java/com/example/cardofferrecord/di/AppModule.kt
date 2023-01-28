package com.example.cardofferrecord.di

import android.content.Context
import androidx.room.Room
import com.example.cardofferrecord.data.CardApplicationInfoDao
import com.example.cardofferrecord.data.CardOfferDatabase
import com.example.cardofferrecord.data.WelcomeOfferDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun cardApplicationInfoDao(cardOfferDatabase: CardOfferDatabase): CardApplicationInfoDao =
        cardOfferDatabase.cardApplicationInfoDao()

    @Singleton
    @Provides
    fun welcomeOfferDao(cardOfferDatabase: CardOfferDatabase): WelcomeOfferDao =
        cardOfferDatabase.welcomeOfferDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): CardOfferDatabase =
        Room.databaseBuilder(
            context,
            CardOfferDatabase::class.java,
            "card_offer_db"
        ).fallbackToDestructiveMigration().build()
}