package com.iulian.iancu.domain

class SendMessageUseCase(private val chatRepository: ChatRepository) {
    private suspend fun run(message: Message) {
        return chatRepository.sendMessage(message)
    }

    suspend operator fun invoke(message: Message) {
        run(message)
    }
}