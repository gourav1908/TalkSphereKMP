package com.talk.sphere.chat.domain

import com.talk.sphere.core.domain.DataError
import com.talk.sphere.core.domain.Result

interface ChatRepository {
    suspend fun displayChat(query: String): Result<List<Chat>, DataError.Remote>
}