package com.keerthi77459.littlelemon.home_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.keerthi77459.littlelemon.ui.theme.littlelemon_foodSelection_color
import com.keerthi77459.littlelemon.ui.theme.littlelemon_gray

@Composable
fun BuildSelectionOption(selectedCategory: String?, onCategorySelected: (String?) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp)
    ) {
        Text(
            text = "ORDER FOR DELIVERY!",
            style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(15.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val categories = listOf("starters", "mains", "desserts", "drinks")

            categories.forEach { category ->
                Box(
                    Modifier
                        .background(color = littlelemon_foodSelection_color, shape = RoundedCornerShape(8.dp))
                        .padding(5.dp)
                        .clickable {
                            onCategorySelected(
                                if (selectedCategory == category) null else category
                            )
                        }
                ) {
                    Text(
                        text = category,
                        style = TextStyle(
                            color = if (selectedCategory == category) Color.Blue else littlelemon_gray,
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}