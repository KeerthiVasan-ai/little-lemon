package com.keerthi77459.littlelemon.home_screen.components

import android.graphics.Typeface
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.keerthi77459.littlelemon.R
import com.keerthi77459.littlelemon.ui.theme.littlelemon_gray
import com.keerthi77459.littlelemon.ui.theme.littlelemon_yellow

@Composable
fun BuildHeroSection(
    searchQuery: String, onSearchQueryChange: (String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(littlelemon_gray)
            .height(300.dp)
            .padding(20.dp)
    ) {
        Text(
            text = "Little Lemon", style = TextStyle(
                fontFamily = FontFamily(Typeface.SERIF),
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = littlelemon_yellow
            )
        )
        Row {
            Box(modifier = Modifier.width(250.dp)) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Chicago", style = TextStyle(
                            fontFamily = FontFamily(Typeface.SERIF),
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = "We are a family-owned Mediterranean restaurant, focused on traditional recipes served with a modern twist",
                        style = TextStyle(
                            fontSize = 18.sp, color = Color.White
                        )
                    )
                }
            }

            Image(
                modifier = Modifier
                    .width(400.dp)
                    .height(130.dp),
                painter = painterResource(id = R.drawable.hero_image),
                contentDescription = "Hero Image",
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        CustomSearchTextField(
            value = searchQuery, onValueChange = onSearchQueryChange, label = "Enter Search Phrase"
        )
    }
}