package com.iulian.iancu.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.iulian.iancu.domain.Message
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Entity
data class LocalMessage(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val text: String,
    val author: String,
    val timestamp: String
)

fun LocalMessage.toEntity(): Message {
    return Message(
        this.text, this.author,
        SimpleDateFormat(
            Message.DATE_FORMAT_IN_DATABASE,
            Locale.getDefault()
        ).parse(this.timestamp) as Date
    )
}
