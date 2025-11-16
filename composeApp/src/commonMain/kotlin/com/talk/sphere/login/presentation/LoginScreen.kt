package com.talk.sphere.login.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.sp
import com.talk.sphere.core.presentation.AppPrimary
import com.talk.sphere.core.presentation.Dimens
import com.talk.sphere.core.presentation.GreyColor
import com.talk.sphere.ui.PrimaryButton
import com.talk.sphere.ui.PrimaryInputText
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.auth.FirebaseUser
import dev.gitlive.firebase.auth.auth
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import talksphere.composeapp.generated.resources.Res
import talksphere.composeapp.generated.resources.email_address
import talksphere.composeapp.generated.resources.enter_email
import talksphere.composeapp.generated.resources.enter_password
import talksphere.composeapp.generated.resources.get_started
import talksphere.composeapp.generated.resources.ic_chat_logo

@Composable
fun LoginScreen() {
    val phoneNumberHint = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val auth = remember { Firebase.auth }
    val firebaseUser: FirebaseUser ? by remember { mutableStateOf(null) }
    val enterEmail = remember { mutableStateOf("") }
    val enterPassword = remember { mutableStateOf("") }
    val isValueChanged = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .imePadding()              // shifts content above keyboard
            .verticalScroll(rememberScrollState())
            .padding(Dimens.dp20)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)   // <-- EXACT CENTER
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(Res.drawable.ic_chat_logo),
                contentDescription = null,
            )
            Text(
                text = stringResource(Res.string.get_started),
                fontSize = 24.sp,
                modifier = Modifier.padding(top = Dimens.dp10)
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
        ) {
            Text(
                text = stringResource(Res.string.email_address).uppercase(),
                modifier = Modifier.padding(top = Dimens.dp4),
                color = AppPrimary
            )

            PrimaryInputText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = Dimens.dp8),
                enabled = true,
                labelText = stringResource(Res.string.enter_email),
                valueText = enterEmail,
                isValueChanged = isValueChanged,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                containerColor = Color.Black,
                textColor = GreyColor,
            )

            PrimaryInputText(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = Dimens.dp10),
                enabled = true,
                labelText = stringResource(Res.string.enter_password),
                valueText = enterPassword,
                isValueChanged = isValueChanged,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                containerColor = Color.Black,
                textColor = GreyColor,
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = Dimens.dp10)
            ) {
                PrimaryButton(
                    onCtaClicked = {

                    },
                    modifier = Modifier.fillMaxWidth(),
                    text = "Get Started"
                )
            }
        }
    }

}

@Composable
@Preview
fun LoginPreview() {
    LoginScreen()
}