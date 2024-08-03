package com.keerthi77459.littlelemon.components


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.keerthi77459.littlelemon.ui.theme.Shapes

@Composable
fun BuildButton(buttonText: String = "Submit", onClick: () -> Unit) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        shape = Shapes.medium,
        contentPadding = PaddingValues(),
        onClick = { onClick() })
    {
        Text(text = buttonText)
    }
}

@Preview
@Composable
fun BuildButtonPreview() {
    BuildButton {}
}