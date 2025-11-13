package com.talk.sphere.chat.presentation

import androidx.lifecycle.ViewModel
import com.talk.sphere.chat.domain.ChatRepository
import com.talk.sphere.core.presentation.Logger

class ChatViewModel(
    private val chatRepository: ChatRepository
) : ViewModel() {
    
    fun initVM() {
        Logger.d("ChatViewModel", "initVM: called()")
    }
}