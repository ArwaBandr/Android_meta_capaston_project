package com.example.androidcapaston.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androidcapaston.PreferencesHelper
import com.example.androidcapaston.R
import com.example.androidcapaston.navigation.Screen

@Composable
fun ProfileScreen(navController: NavHostController) {
    var context = LocalContext.current
    val fName = PreferencesHelper.getFirstname(context)
    val lName = PreferencesHelper.getLastname(context)
    val email = PreferencesHelper.getEmail(context)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            Modifier
                .fillMaxWidth()
                .size(80.dp)
                .padding(top = 10.dp, bottom = 20.dp)
        )
        Text(
            text = "Profile information",
            style = typography.headlineMedium,
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            "First Name: $fName", modifier = Modifier.padding(top = 8.dp),
            style = typography.bodyMedium
        )
        Text(
            "Last Name: $lName", modifier = Modifier.padding(top = 8.dp),
            style = typography.bodyMedium
        )
        Text(
            "Email: $email", modifier = Modifier.padding(top = 8.dp),
            style = typography.bodyMedium
        )

        Button(
            onClick = {
                // PreferencesHelper.getSharedPreferences(context).edit().clear().apply()
                PreferencesHelper.clearUserData(context)
                navController.navigate(Screen.onboardingScreen.rout) {
                    popUpTo(Screen.onboardingScreen.rout) { inclusive = true }
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Log out")
        }
    }
}

