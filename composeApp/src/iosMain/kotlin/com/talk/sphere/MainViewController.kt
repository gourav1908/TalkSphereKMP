package com.talk.sphere

import androidx.compose.ui.window.ComposeUIViewController
import com.talk.sphere.core.presentation.app.App
import com.talk.sphere.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }