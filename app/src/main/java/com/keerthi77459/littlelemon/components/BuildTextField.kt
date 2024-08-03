package com.keerthi77459.littlelemon.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun BuildTextField(
    value: String,
    onValueChange: (String) -> Unit,
    showError: Boolean = false,
    errorMessage: String = "Required Field",
    readOnly: Boolean,
    focusRequester: FocusRequester? = null,
    label: String
) {
    Column {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester ?: FocusRequester()),
            value = value,
            onValueChange = { onValueChange(it) },
            isError = showError,
            label = { Text(label) },
            readOnly = readOnly,
            visualTransformation = VisualTransformation.None
        )
        if (showError) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .offset(y = (8).dp)
                    .fillMaxWidth(0.9f)
            )
        }
    }
}