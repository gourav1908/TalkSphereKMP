package com.talk.sphere.login.presentation

import androidx.lifecycle.ViewModel
import com.talk.sphere.chat.domain.ChatRepository
import com.talk.sphere.core.presentation.Logger
import dev.gitlive.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel (
    private val chatRepository: ChatRepository,
    private val firebaseAuth: FirebaseAuth
) : ViewModel() {
    private val _loginUIState = MutableStateFlow<UserUIState>(UserUIState.defaultState)
    val loginUIState: StateFlow<UserUIState> = _loginUIState.asStateFlow()
    var enteredEmail = ""

    fun onSubmitPhoneClicked(phoneNumber: String) {
        Logger.e(TAG, "onRefreshPageCTAClick() phoneNumber: $phoneNumber")
        enteredEmail = phoneNumber

        // display OTP screen
//        startPhoneAuthentication(phoneNumber, activity) // OTP verification starts
    }

    companion object {
        const val TAG = "LoginViewModel"
    }

}