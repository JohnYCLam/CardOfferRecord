package com.example.cardofferrecord.data

import androidx.room.*
import com.example.cardofferrecord.model.CardApplicationInfo
import kotlinx.coroutines.flow.Flow

@Dao
interface CardOfferDao {


    @Query("SELECT * from card_application_info_tbl")
    fun getCardApplication(): Flow<List<CardApplicationInfo>>

    @Query("SELECT * from card_application_info_tbl where id =:id")
    suspend fun getCardApplicationById(id: String): CardApplicationInfo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cardApplicationInfo: CardApplicationInfo)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(cardApplicationInfo: CardApplicationInfo)

    @Query("DELETE from card_application_info_tbl")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteCardApplicationInfo(cardApplicationInfo: CardApplicationInfo)

}
