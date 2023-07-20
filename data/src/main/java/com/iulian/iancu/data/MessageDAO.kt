package com.iulian.iancu.data

import androidx.room.Dao
import androidx.room.DeleteTable
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MessageDAO {
    @Insert
    suspend fun insertMessage(message: LocalMessage)

    @Query("SELECT * FROM LocalMessage ORDER BY timestamp")
    fun getMessagesByLatest(): Flow<List<LocalMessage>>

    @Query("DROP TABLE LocalMessage")
    fun deleteMessages()
}