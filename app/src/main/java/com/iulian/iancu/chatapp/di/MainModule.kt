package com.iulian.iancu.chatapp.di

import android.content.Context
import androidx.room.Room
import com.iulian.iancu.data.ChatRepositoryImpl
import com.iulian.iancu.data.MessageDAO
import com.iulian.iancu.data.MessageDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class MainModule {

    @Provides
    fun provideGetChatUseCase(repository: ChatRepositoryImpl): com.iulian.iancu.domain.GetChatUseCase =
        com.iulian.iancu.domain.GetChatUseCase(repository)

    @Provides
    fun provideSendMessageUseCase(repository: ChatRepositoryImpl): com.iulian.iancu.domain.SendMessageUseCase =
        com.iulian.iancu.domain.SendMessageUseCase(repository)

    @Provides
    fun provideChatRepository(messageDAO: MessageDAO): ChatRepositoryImpl =
        ChatRepositoryImpl(messageDAO)

    @Provides
    fun provideChatDAO(messageDatabase: MessageDatabase): MessageDAO = messageDatabase.messageDAO()

    @Provides
    @Singleton
    fun provideChatDatabase(@ApplicationContext appContext: Context): MessageDatabase =
        Room.databaseBuilder(
            context = appContext,
            MessageDatabase::class.java,
            "Messages.db"
        ).build()
}