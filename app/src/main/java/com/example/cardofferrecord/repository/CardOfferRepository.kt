package com.example.cardofferrecord.repository

import com.example.cardofferrecord.data.CardOfferDao
import com.example.cardofferrecord.model.CardApplicationInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CardOfferRepository @Inject constructor(private val cardOfferDao: CardOfferDao) {
    suspend fun addCardOffer(cardApplicationInfo: CardApplicationInfo) = cardOfferDao.insert(cardApplicationInfo)
    suspend fun updateCardOffer(cardApplicationInfo: CardApplicationInfo) = cardOfferDao.update(cardApplicationInfo)
    suspend fun deleteCardOffer(cardApplicationInfo: CardApplicationInfo) = cardOfferDao.deleteCardApplicationInfo(cardApplicationInfo)
    suspend fun deleteAllCardOffer(cardApplicationInfo: CardApplicationInfo) = cardOfferDao.deleteAll()
    //fun getAllCardOffer(): Flow<List<CardApplicationInfo>> = cardOfferDao.getCardApplication().flowOn(Dispatchers.IO).conflate()
}