package com.keerthi77459.littlelemon.on_boarding.components

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.keerthi77459.littlelemon.components.BuildButton
import com.keerthi77459.littlelemon.components.BuildTextField

@Composable
fun BuildUserForm(context: Context) {

    var firstName by remember {
        mutableStateOf("")
    }

    var lastName by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Text(
            text = "Personal Details", style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(50.dp))
        BuildTextField(
            value = firstName,
            onValueChange = { firstName = it },
            readOnly = false,
            label = "First Name"
        )
        Spacer(modifier = Modifier.height(30.dp))
        BuildTextField(
            value = lastName,
            onValueChange = { lastName = it },
            readOnly = false,
            label = "Last Name"
        )
        Spacer(modifier = Modifier.height(30.dp))
        BuildTextField(
            value = email,
            onValueChange = { email = it },
            readOnly = false,
            label = "Email"
        )
        Spacer(modifier = Modifier.height(100.dp))
        BuildButton(buttonText = "Register") {
            performLogin(context, firstName, lastName, email)
        }
    }
}

fun performLogin(context: Context, firstName: String, lastName: String, email: String) {
    val sharedPref: SharedPreferences =
        context.getSharedPreferences("LoginPreferences", Context.MODE_PRIVATE)
    val editor: SharedPreferences.Editor = sharedPref.edit()
    editor.putString("first_name", firstName)
    editor.putString("last_name", lastName)
    editor.putString("email", email)
    editor.apply()
}
