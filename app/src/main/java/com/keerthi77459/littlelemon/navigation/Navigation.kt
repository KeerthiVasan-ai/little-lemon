package com.keerthi77459.littlelemon.navigation

sealed class Navigation(val route:String){
    data object OnBoardingScreen: Navigation("on_boarding_screen")
    data object HomeScreen: Navigation("home_screen")
    data object ProfileScreen: Navigation("profile_screen")
}