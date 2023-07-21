package com.iulian.iancu.chatapp.di

import android.content.Context
import androidx.room.Room
import com.iulian.iancu.data.MessageDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideChatDatabase(@ApplicationContext appContext: Context): MessageDatabase =
        Room.databaseBuilder(
            context = appContext,
            MessageDatabase::class.java,
            "Messages.db"
        ).build()
}