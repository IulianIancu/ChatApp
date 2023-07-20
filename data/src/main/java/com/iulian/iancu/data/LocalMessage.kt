package com.iulian.iancu.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class LocalMessage(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val text: String,
    val author: String,
    val timestamp: Date
)
