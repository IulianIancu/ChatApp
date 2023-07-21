package com.iulian.iancu.chatapp.di

import android.content.Context
import androidx.room.Room
import com.iulian.iancu.data.ChatRepositoryImpl
import com.iulian.iancu.data.MessageDAO
import com.iulian.iancu.data.MessageDatabase
import com.iulian.iancu.domain.GetChatUseCase
import com.iulian.iancu.domain.SendMessageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class MainModule {

    @Provides
    fun provideGetChatUseCase(repository: ChatRepositoryImpl): GetChatUseCase =
        GetChatUseCase(repository)

    @Provides
    fun provideSendMessageUseCase(repository: ChatRepositoryImpl): SendMessageUseCase =
        SendMessageUseCase(repository)

    @Provides
    fun provideChatRepository(messageDAO: MessageDAO): ChatRepositoryImpl =
        ChatRepositoryImpl(messageDAO)

    @Provides
    fun provideChatDAO(messageDatabase: MessageDatabase): MessageDAO = messageDatabase.messageDAO()


}