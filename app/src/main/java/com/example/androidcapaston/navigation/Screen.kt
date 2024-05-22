package com.example.androidcapaston.navigation

sealed class Screen (val rout:String){
    object onboardingScreen :Screen("on_borading_screen")
    object profileScreen :Screen("profile_screen")
    object homeScreen :Screen("home_screen")
}