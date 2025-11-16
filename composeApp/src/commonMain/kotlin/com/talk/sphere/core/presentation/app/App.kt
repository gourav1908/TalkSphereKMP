package com.talk.sphere.core.presentation.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.talk.sphere.chat.presentation.ChatScreen
import com.talk.sphere.login.presentation.LoginScreen
import com.talk.sphere.ui.splash.SplashScreen
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseUser
import dev.gitlive.firebase.auth.auth
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
@Preview
fun App() {
    MaterialTheme {
        val scope = rememberCoroutineScope()
        val auth = remember { Firebase.auth }
        val firebaseUser: FirebaseUser? by remember { mutableStateOf(null) }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Route.SplashScreen) {
            composable<Route.SplashScreen> {
                SplashScreen(
                    onNavigateToChat = {
                        navController.navigate(Route.LoginScreen) {
                            popUpTo(Route.SplashScreen) { inclusive = true }
                            launchSingleTop = true
                        }
                    }
                )
            }
            composable<Route.LoginScreen> {
                LoginScreen()
            }
            composable<Route.ChatList> {
                ChatScreen()
            }
            // You can add more destinations similarly
        }
    }
}

/*
@Composable
private inline fun <reified T: ViewModel> NavBackStackEntry.sharedKoinViewModel(
    navController: NavController
): T {
    val navGraphRoute = destination.parent?.route ?: return koinViewModel<T>()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return koinViewModel(
        viewModelStoreOwner = parentEntry
    )
}*/
