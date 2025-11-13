package com.talk.sphere.app

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
                            navController.navigate(Route.ChatList) {
                                popUpTo(Route.SplashScreen) { inclusive = true }
                                launchSingleTop = true
                            }
                        }
                    )
                }
                composable<Route.ChatList> {
                    ChatScreen()
                }
            // You can add more destinations similarly
        }
        /*NavHost(
            navController = navController,
            startDestination = Route.SplashScreen
        ) {
            navigation<Route.SplashScreen>(
                startDestination = Route.SplashScreen
            ) {
                // Splash
                composable<Route.SplashScreen> {
                    SplashScreen(
                        onNavigateToChat = {
                            navController.navigate(Route.ChatList) {
                                // Remove splash from back stack so Back won't return to it
                                popUpTo(Route.SplashScreen) { inclusive = true }
                                launchSingleTop = true
                            }
                        }
                    )
                }

                // Chat
                composable<Route.ChatList>(
                    exitTransition = { slideOutHorizontally() },
                    popEnterTransition = { slideInHorizontally() }
                ) {
                    // Grab your VM from Koin in the destination scope
//                    val viewModel = koinViewModel<ChatViewModel>()
                    ChatScreen()
                }
            }
            *//*navigation<Route.SplashScreen>(
                startDestination = Route.ChatList
            ) {
                composable<Route.ChatList>(
                    exitTransition = { slideOutHorizontally() },
                    popEnterTransition = { slideInHorizontally() }
                ) {
                    val viewModel = koinViewModel<ChatViewModel>()
                }
            }*//*
        }*/

        /*var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }*/
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
