package com.talk.sphere.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.talk.sphere.core.presentation.GreyColor
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import talksphere.composeapp.generated.resources.Res
import talksphere.composeapp.generated.resources.book_cover

@Composable
fun PrimaryInputText(
    modifier: Modifier = Modifier,
    labelText: String,
    valueText: MutableState<String>,
    isValueChanged: MutableState<Boolean>,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    singleLine: Boolean = true,
    enabled: Boolean = true,
    textColor: Color = Color.White,
    containerColor: Color = Color.White,
    shape: CornerBasedShape = shapes.medium
) {
    OutlinedTextField(
        modifier = Modifier
            .then(modifier)
            .fillMaxWidth()
            .background(Color.Transparent),
        enabled = enabled,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledTextColor = textColor,
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            focusedLabelColor = textColor,
            unfocusedLabelColor = textColor,
            focusedIndicatorColor = containerColor,
            unfocusedIndicatorColor = containerColor, // outer border
            disabledContainerColor = GreyColor,
            disabledIndicatorColor = containerColor,
            cursorColor = textColor
        ),
        singleLine = singleLine,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        shape = shape,
        value = valueText.value,
        onValueChange = {
            valueText.value = it
            isValueChanged.value = true
        },
        label = {
            Text(
                text = labelText,
                color = textColor,
                style = typography.bodySmall
            )
        },
        textStyle = typography.bodySmall,
        keyboardOptions = keyboardOptions
    )
}

@Preview(
    showBackground = true,
    backgroundColor = 0xd5d5d5
)
@Composable
fun PreviewTextField() {
    PrimaryInputText(
        modifier = Modifier.padding(20.dp),
        labelText = "Enter Text",
        valueText = mutableStateOf("Hello world"),
        isValueChanged = mutableStateOf(false),
    )
}


@Preview(
    showBackground = true,
    backgroundColor = 0xd5d5d5
)
@Composable
fun PreviewTextFieldDisabled() {
    PrimaryInputText(
        modifier = Modifier.padding(20.dp),
        enabled = false,
        labelText = "Enter Text",
        valueText = mutableStateOf("Hello world"),
        isValueChanged = mutableStateOf(false),
    )
}

@Preview(
    showBackground = true,
    backgroundColor = 0xd5d5d5
)
@Composable
fun PreviewInput() {
    PrimaryInputText(
        modifier = Modifier
            .padding(10.dp),
        labelText = stringResource(Res.string.book_cover),
        valueText = mutableStateOf(""),
        isValueChanged = mutableStateOf(false),
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        textColor = GreyColor,
        containerColor = GreyColor,
    )
}
