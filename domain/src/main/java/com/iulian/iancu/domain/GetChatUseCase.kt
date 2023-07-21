package com.iulian.iancu.domain

import kotlinx.coroutines.flow.Flow

class GetChatUseCase(private val chatRepository: ChatRepository) {
    private suspend fun run(): Flow<List<Message>> {
        return chatRepository.getAllChat()
    }

    suspend operator fun invoke(): Flow<List<Message>> {
        return run()
    }
}