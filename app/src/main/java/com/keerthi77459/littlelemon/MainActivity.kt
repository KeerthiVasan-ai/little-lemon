package com.keerthi77459.littlelemon

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.keerthi77459.littlelemon.navigation.NavigationRouteMap
import com.keerthi77459.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val isLogin = getLoginData()
        setContent {
            LittleLemonTheme {
                NavigationRouteMap(context = this, isLogin = isLogin)
            }
        }
    }

    private fun getLoginData(): Boolean {
        val sharedPref: SharedPreferences =
            getSharedPreferences("LoginPreferences", Context.MODE_PRIVATE)
        val firstName = sharedPref.getString("first_name", null)
        val secondName = sharedPref.getString("last_name", null)
        val email = sharedPref.getString("email", null)

        return !(firstName.isNullOrEmpty() && secondName.isNullOrEmpty() && email.isNullOrEmpty())
    }
}