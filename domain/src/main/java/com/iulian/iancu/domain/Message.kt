package com.iulian.iancu.domain

import java.util.Date

data class Message(
    val text: String,
    val author: String,
    val timestamp: Date
)