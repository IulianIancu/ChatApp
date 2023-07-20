package com.iulian.iancu.data

import com.iulian.iancu.domain.ChatRepository
import com.iulian.iancu.domain.Message

class ChatRepositoryImpl(database: MessageDAO) : ChatRepository {
    override suspend fun getAllChat(): List<Message> {
        TODO("Not yet implemented")
    }

    override suspend fun sendMessage(message: Message) {
        TODO("Not yet implemented")
    }
}