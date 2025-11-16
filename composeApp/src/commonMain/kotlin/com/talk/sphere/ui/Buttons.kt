package com.talk.sphere.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.talk.sphere.core.presentation.AppPrimary
import com.talk.sphere.core.presentation.ButtonRed
import com.talk.sphere.core.presentation.Dimens
import com.talk.sphere.core.presentation.LightGreyColor
import com.talk.sphere.core.presentation.TextColor
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun PrimaryButton(
    text: String,
    modifier: Modifier = Modifier,
    shape: CornerBasedShape = shapes.medium,
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
    containerColor: Color = AppPrimary,
    onCtaClicked: () -> Unit,
) {
    Button(
        shape = shape,
        modifier = modifier
            .height(54.dp)
            .then(modifier),
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            disabledContainerColor = ButtonRed.copy(alpha = 0.5f),
            disabledContentColor = colorScheme.onPrimary.copy(alpha = 0.5f),
            contentColor = colorScheme.onPrimary,
            containerColor = containerColor
        ),
        onClick = onCtaClicked,
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(Dimens.dp24), // Size of the spinner
                color = colorScheme.onPrimary
            )
        } else {
            Text(text = text)
        }
    }
}

@Composable
fun CustomTextButton(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = TextColor,
    onCtaClicked: () -> Unit,
) {
    TextButton(
        onClick = onCtaClicked,
        modifier = modifier.height(Dimens.dp24),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(text, color = color, textAlign = TextAlign.Start)
    }
}

@Composable
fun OutlinedButton(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = LightGreyColor,
    shape: CornerBasedShape = shapes.medium,
    onCtaClicked: () -> Unit,
) {
    OutlinedButton(
        onClick = onCtaClicked,
        shape = shape,
        border = BorderStroke(1.dp, color),
        modifier = modifier
            .then(modifier)
            .height(44.dp)
    ) {
        Text(text = text, color = color)
    }
}

@Composable
fun SmallOutlinedButton(
    modifier: Modifier = Modifier,
    text: String,
    strokeColor: Color = LightGreyColor,
    width: Dp = 50.dp,
    onCtaClicked: () -> Unit,
) {
    Box(
        modifier = Modifier
            .then(modifier)
            .border(1.dp, strokeColor, shapes.extraSmall)
            .clickable {
                onCtaClicked()
            }
    ) {
        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier.
                width(width).
            padding(horizontal = 8.dp, vertical = 5.dp),
            text = text,
            color = strokeColor,
            style = TextStyle.Default.copy(fontSize = 10.sp)
        )
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {
    PrimaryButton(
        onCtaClicked = {}, modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp),
        text = "Get Started"
    )
}

@Preview
@Composable
fun CustomTextButtonPreview() {
    CustomTextButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 12.dp),
        text = "Delete my account",
    ) {

    }
}

@Preview
@Composable
fun OutlinedButtonPreview() {
    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 12.dp),
        text = "Outlined button",
    ) {

    }
}

@Preview
@Composable
fun SmallOutlinedButtonPreview() {
    Box(
        modifier = Modifier
            .padding(10.dp),
    ) {
        SmallOutlinedButton(
            text = "Small Outlined button",
        ) {

        }
    }
}