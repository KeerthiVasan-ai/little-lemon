package com.keerthi77459.littlelemon.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuildAppBar(
    title: String,
    showIcon: Boolean = false,
    icon: Painter,
    onAction: () -> Unit = {}
) {
    TopAppBar(
        title = { Text(text = title) },
        colors = TopAppBarDefaults.topAppBarColors(Color.Transparent),
        actions = {
            if (showIcon) {
                IconButton(onClick = onAction) {
                    Image(
                        modifier = Modifier.size(50.dp),
                        painter = icon,
                        contentScale = ContentScale.Fit,
                        contentDescription = null
                    )
                }
            }
        },
    )
}