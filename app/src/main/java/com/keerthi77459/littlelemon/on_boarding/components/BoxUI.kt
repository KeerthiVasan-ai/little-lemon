package com.keerthi77459.littlelemon.on_boarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.keerthi77459.littlelemon.ui.theme.littlelemon_gray

@Composable
fun BuildBoxUI() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = littlelemon_gray)
            .padding(40.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Let's get to Know you", style = TextStyle(
                fontSize = 32.sp,
                color = Color.White
            )
        )

    }
}