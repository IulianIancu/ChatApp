package com.iulian.iancu.domain

class GetChatUseCase(private val chatRepository: ChatRepository) {
    private suspend fun run(): List<Message> {
        return chatRepository.getAllChat()
    }

    suspend operator fun invoke(): List<Message> {
        return run()
    }
}