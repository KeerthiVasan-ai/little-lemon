package com.keerthi77459.littlelemon.home_screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.keerthi77459.littlelemon.home_screen.data.MenuItemEntity

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BuildMenuView(menuItem: MenuItemEntity) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(horizontal = 10.dp)
    ) {
        Text(
            text = menuItem.name, style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.width(270.dp)
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = menuItem.description,
                    style = TextStyle(
                        fontSize = 16.sp
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    "$ ${menuItem.price}", style = TextStyle(
                        fontSize = 18.sp
                    )
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(350.dp)
                    .size(70.dp)
            ) {
                GlideImage(
                    model = menuItem.image,
                    contentDescription = "Food",
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}