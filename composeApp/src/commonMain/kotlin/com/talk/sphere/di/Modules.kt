package com.talk.sphere.di


import com.talk.sphere.chat.data.ChatRepositoryImpl
import com.talk.sphere.chat.domain.ChatRepository
import com.talk.sphere.chat.presentation.ChatViewModel
import com.talk.sphere.core.data.HttpClientFactory
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single { HttpClientFactory.create(get()) }
    singleOf(::ChatRepositoryImpl).bind<ChatRepository>()
//    singleOf(::KtorRemoteBookDataSource).bind<RemoteBookDataSource>() // Local DB

    /*single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<FavoriteBookDatabase>().favoriteBookDao }*/ // Local DB

    viewModelOf(::ChatViewModel)
}