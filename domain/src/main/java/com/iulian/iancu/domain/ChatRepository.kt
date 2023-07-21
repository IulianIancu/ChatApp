package com.iulian.iancu.domain

import kotlinx.coroutines.flow.Flow

interface ChatRepository {
    suspend fun getAllChat(): Flow<List<Message>>
    suspend fun sendMessage(message: Message)
}