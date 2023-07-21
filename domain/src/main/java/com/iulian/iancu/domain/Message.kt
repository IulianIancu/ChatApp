package com.iulian.iancu.domain

import java.util.Date

data class Message(
    val text: String,
    val author: String,
    val timestamp: Date
){
    companion object{
        const val DATE_FORMAT_IN_DATABASE = "yyyy-MM-dd'T'HH:mm:ss"
    }
}