package com.iulian.iancu.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [LocalMessage::class],
    version = 1
)
abstract class MessageDatabase : RoomDatabase() {
    abstract fun messageDAO(): MessageDAO
}