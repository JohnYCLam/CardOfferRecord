package com.example.cardofferrecord.data

import androidx.room.*
import com.example.cardofferrecord.model.CardApplicationInfo
import com.example.cardofferrecord.model.WelcomeOffer
import kotlinx.coroutines.flow.Flow

@Dao
interface CardOfferDao {


    @Query("SELECT * from card_application_info_tbl")
    fun getAllCardApplication(): Flow<List<CardApplicationInfo>>

    @Query("SELECT * from card_application_info_tbl where id =:id")
    suspend fun getOneCardApplicationById(id: String): CardApplicationInfo

    @Query("SELECT * from welcome_offer_tbl where card_application_id =:id")
    fun getAllWelcomeOfferByCardId(id: String): Flow<List<WelcomeOffer>>

    @Query("SELECT * from welcome_offer_tbl where id =:id")
    suspend fun getOneWelcomeOfferById(id: String): WelcomeOffer

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cardApplicationInfo: CardApplicationInfo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(welcomeOffer: WelcomeOffer)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(cardApplicationInfo: CardApplicationInfo)

    @Query("DELETE from card_application_info_tbl")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteCardApplicationInfo(cardApplicationInfo: CardApplicationInfo)

}
