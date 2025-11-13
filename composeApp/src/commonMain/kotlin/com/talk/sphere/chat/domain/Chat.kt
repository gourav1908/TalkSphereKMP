package com.talk.sphere.chat.domain

data class Chat(
    val senderId: String,
    val receiverId: String,
    val message: String,
)
