package com.talk.sphere.app

import kotlinx.serialization.Serializable


sealed interface Route {

    @Serializable
    data object SplashScreen: Route

    @Serializable
    data object ChatList: Route

    @Serializable
    data class BookDetail(val id: String): Route
}