package com.example.cardofferrecord.repository

import com.example.cardofferrecord.data.CardApplicationInfoDao
import com.example.cardofferrecord.data.WelcomeOfferDao
import com.example.cardofferrecord.model.CardApplicationInfo
import com.example.cardofferrecord.model.WelcomeOffer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CardOfferRepository @Inject constructor(private val cardApplicationInfoDao: CardApplicationInfoDao, private val welcomeOfferDao: WelcomeOfferDao) {
    suspend fun addCardApplication(cardApplicationInfo: CardApplicationInfo) = cardApplicationInfoDao.insert(cardApplicationInfo)
    suspend fun updateCardApplication(cardApplicationInfo: CardApplicationInfo) = cardApplicationInfoDao.update(cardApplicationInfo)
    suspend fun deleteCardApplication(cardApplicationInfo: CardApplicationInfo) = cardApplicationInfoDao.deleteCardApplicationInfo(cardApplicationInfo)
    suspend fun deleteAllCardApplication() = cardApplicationInfoDao.deleteAll()
    suspend fun getOneCardApplicationById(cardApplicationId: String) = cardApplicationInfoDao.getOneCardApplicationById(cardApplicationId)
    fun getAllCardApplication(): Flow<List<CardApplicationInfo>> = cardApplicationInfoDao.getAllCardApplication().flowOn(
        Dispatchers.IO).conflate()

    fun getAllWelcomeOffer(): Flow<List<WelcomeOffer>> = welcomeOfferDao.getAllWelcomeOffer().flowOn(
        Dispatchers.IO).conflate()
    fun getAllWelcomeOfferByCard(cardApplicationId: String): Flow<List<WelcomeOffer>> = welcomeOfferDao.getAllWelcomeOfferByCard(cardApplicationId).flowOn(
        Dispatchers.IO).conflate()
    suspend fun getOneWelcomeOfferByCard(welcomeOfferId: String) = welcomeOfferDao.getOneWelcomeOfferByCard(welcomeOfferId)
    suspend fun addWelcomeOffer(welcomeOffer: WelcomeOffer) = welcomeOfferDao.insert(welcomeOffer)
    suspend fun updateWelcomeOffer(welcomeOffer: WelcomeOffer) = welcomeOfferDao.update(welcomeOffer)
    suspend fun deleteWelcomeOffer(welcomeOffer: WelcomeOffer) = welcomeOfferDao.deleteWelcomeOffer(welcomeOffer)
    suspend fun deleteAllWelcomeOffer() = welcomeOfferDao.deleteAll()

}