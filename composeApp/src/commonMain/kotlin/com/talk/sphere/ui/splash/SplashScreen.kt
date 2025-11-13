package com.talk.sphere.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.talk.sphere.presentation.AppPrimary
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import talksphere.composeapp.generated.resources.Res
import talksphere.composeapp.generated.resources.ic_chat_logo

@Composable
fun SplashScreen(
    onNavigateToChat: () -> Unit,
) {
    // Fire once on enter: wait 3s, then navigate
    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(3_000)
        onNavigateToChat()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(Res.drawable.ic_chat_logo),
                contentDescription = null,
            )
            Text("Hello", fontSize = 24.sp)
            Text("Chat.", color = AppPrimary, fontSize = 24.sp)
            Text("The last chat app you’ll ever need.")
        }
    }
}

@Preview
@Composable
fun SplashPreview() {
    SplashScreen {  }
}