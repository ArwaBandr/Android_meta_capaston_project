package com.example.androidcapaston.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidcapaston.PreferencesHelper
import com.example.androidcapaston.PreferencesHelper.KEY_EMAIL
import com.example.androidcapaston.data.database.AppDatabase
import com.example.androidcapaston.onboarding.HomeScreen
import com.example.androidcapaston.onboarding.OnBoardingScreen
import com.example.androidcapaston.onboarding.ProfileScreen

@Composable
fun NavGraph(navController: NavHostController,database: AppDatabase){
    val hasUserData = hasUserDataInSharedPreferences()
    NavHost(navController = navController, startDestination = if (hasUserData) Screen.onboardingScreen.rout else Screen.homeScreen.rout ){
        composable(Screen.onboardingScreen.rout){
            OnBoardingScreen(navController)
        }
        composable(Screen.homeScreen.rout){
            HomeScreen(navController,database)
        }
        composable(Screen.profileScreen.rout){
            ProfileScreen(navController)
        }
    }
}
@Composable
fun hasUserDataInSharedPreferences(): Boolean {
    val context = LocalContext.current
    val sharedPreferences = PreferencesHelper.getSharedPreferences(context)
    val email =sharedPreferences.getString(KEY_EMAIL,"") ?: ""
    return email.isNotBlank()
}