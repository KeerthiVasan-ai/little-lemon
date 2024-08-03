package com.keerthi77459.littlelemon.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.keerthi77459.littlelemon.home_screen.data.AppDatabase
import com.keerthi77459.littlelemon.home_screen.screens.HomeScreen
import com.keerthi77459.littlelemon.on_boarding.screens.OnBoardingScreen
import com.keerthi77459.littlelemon.profile_screen.screens.ProfileScreen

@Composable
fun NavigationRouteMap(
    database: AppDatabase,
    context: Context,
    isLogin: Boolean,
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = getStartDestination(isLogin)) {
        composable(route = Navigation.OnBoardingScreen.route) {
            OnBoardingScreen(context)
        }
        composable(route = Navigation.HomeScreen.route) {
            HomeScreen(database, navController)
        }
        composable(route = Navigation.ProfileScreen.route) {
            ProfileScreen(context, navController)
        }
    }
}

fun getStartDestination(isLogin: Boolean): String {
    return if (isLogin) {
        Navigation.HomeScreen.route
    } else {
        Navigation.OnBoardingScreen.route
    }
}
