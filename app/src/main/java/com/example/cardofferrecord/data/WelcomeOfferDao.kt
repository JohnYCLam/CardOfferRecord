package com.example.cardofferrecord.data

import androidx.room.*
import com.example.cardofferrecord.model.WelcomeOffer
import kotlinx.coroutines.flow.Flow

@Dao
interface WelcomeOfferDao {

    @Query("SELECT * from welcome_offer_tbl where card_application_id =:id")
    fun getAllWelcomeOfferByCard(id: String): Flow<List<WelcomeOffer>>

    @Query("SELECT * from welcome_offer_tbl where id =:id")
    suspend fun getOneWelcomeOfferByCard(id: String): WelcomeOffer

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(welcomeOffer: WelcomeOffer)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(welcomeOffer: WelcomeOffer)

    @Query("DELETE from welcome_offer_tbl")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteWelcomeOffer(welcomeOffer: WelcomeOffer)
}