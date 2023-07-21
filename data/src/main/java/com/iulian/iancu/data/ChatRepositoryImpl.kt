package com.iulian.iancu.data

import com.iulian.iancu.domain.Message
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.text.SimpleDateFormat
import java.util.Locale

class ChatRepositoryImpl(val database: MessageDAO) : com.iulian.iancu.domain.ChatRepository {
    override suspend fun getAllChat(): Flow<List<Message>> {
        return database.getMessagesByLatest()
            .map { it.map { localMessage -> localMessage.toEntity() } }
    }

    override suspend fun sendMessage(message: Message) {
        database.insertMessage(
            LocalMessage(
                text = message.text,
                author = message.author,
                timestamp = SimpleDateFormat(
                    Message.DATE_FORMAT_IN_DATABASE,
                    Locale.getDefault()
                ).format(message.timestamp)
            )
        )
    }
}