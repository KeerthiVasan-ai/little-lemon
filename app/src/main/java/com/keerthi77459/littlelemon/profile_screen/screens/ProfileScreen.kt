package com.keerthi77459.littlelemon.profile_screen.screens

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.keerthi77459.littlelemon.R
import com.keerthi77459.littlelemon.components.BuildButton
import com.keerthi77459.littlelemon.components.BuildTextField
import com.keerthi77459.littlelemon.navigation.Navigation

@Composable
fun ProfileScreen(context: Context, navController: NavController) {
    val sharedPref: SharedPreferences =
        context.getSharedPreferences("LoginPreferences", Context.MODE_PRIVATE)

    var firstName by remember {
        mutableStateOf(sharedPref.getString("first_name", ""))
    }
    var secondName by remember {
        mutableStateOf(sharedPref.getString("last_name", ""))
    }
    var email by remember {
        mutableStateOf(sharedPref.getString("email", ""))
    }


    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(90.dp)
                    .padding(16.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Little Lemon Logo",
                contentScale = ContentScale.Fit
            )
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Spacer(modifier = Modifier.height(70.dp))
                Text(
                    text = "Personal Information",
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp)
                )
                Spacer(modifier = Modifier.height(50.dp))
                firstName?.let { it1 ->
                    BuildTextField(
                        value = it1,
                        onValueChange = { firstName = it1 },
                        readOnly = true,
                        label = "First Name"
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                secondName?.let { it2 ->
                    BuildTextField(
                        value = it2,
                        onValueChange = { secondName = it2 },
                        readOnly = true,
                        label = "Last Name"
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                email?.let { it3 ->
                    BuildTextField(
                        value = it3,
                        onValueChange = { email = it3 },
                        readOnly = true,
                        label = "Email"
                    )
                }
                Spacer(modifier = Modifier.height(190.dp))
                BuildButton(buttonText = "Logout") {
                    signOut(sharedPref, navController)
                }
            }
        }
    }
}

fun signOut(sharedPref: SharedPreferences, navController: NavController) {
    val editor: SharedPreferences.Editor = sharedPref.edit()
    editor.putString("first_name", null)
    editor.putString("last_name", null)
    editor.putString("email", null)
    editor.apply()
    navController.navigate(Navigation.OnBoardingScreen.route)
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(LocalContext.current, rememberNavController())
}