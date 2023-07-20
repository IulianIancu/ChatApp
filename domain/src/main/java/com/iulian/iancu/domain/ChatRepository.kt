package com.iulian.iancu.domain

interface ChatRepository {

    suspend fun getAllChat(): List<Message>
    suspend fun sendMessage(message: Message)
}