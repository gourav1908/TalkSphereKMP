package com.talk.sphere.chat.data

import com.talk.sphere.chat.domain.Chat
import com.talk.sphere.chat.domain.ChatRepository
import com.talk.sphere.core.domain.DataError
import com.talk.sphere.core.domain.Result

class ChatRepositoryImpl: ChatRepository {
    override suspend fun displayChat(query: String): Result<List<Chat>, DataError.Remote> {
        TODO("Not yet implemented")
    }
}