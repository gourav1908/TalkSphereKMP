package com.talk.sphere.chat.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.talk.sphere.core.presentation.AppPrimary
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import talksphere.composeapp.generated.resources.Res
import talksphere.composeapp.generated.resources.ic_chat_logo

@Composable
fun ChatScreen() {
    val viewmodel = koinInject<ChatViewModel>()
//    val vm: ChatViewModel = koinViewModel()
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
        Text("This is the TalkSphere Chat App", fontSize = 24.sp)
        Text("Start Chat.", color = AppPrimary, fontSize = 24.sp)
    }
    viewmodel.initVM()
}

@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    ChatScreen()
}