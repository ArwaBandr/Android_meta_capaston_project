package com.example.androidcapaston.onboarding

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnBoardingScreen(navController: NavHostController) {
    Column(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            Modifier
                .fillMaxWidth()
                .size(80.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 10.dp, bottom = 20.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(color = Color(0xFF263b21)),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Let's get to know you", fontSize = 20.sp, color = Color.White)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Text(
                text = "Personal information",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 20.dp, bottom = 20.dp)
            )
            var fName by rememberSaveable {
                mutableStateOf("")
            }
            var lName by rememberSaveable {
                mutableStateOf("")
            }
            var email by rememberSaveable {
                mutableStateOf("")
            }

            Column(
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextField(
                    value = fName,
                    onValueChange = { fName = it },
                    label = { Text(text = "First name") },
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(10.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedLabelColor = Color.Gray,
                        unfocusedLabelColor = Color.Gray,
                        containerColor = Color.White
                    )
                )

                TextField(
                    value = lName,
                    onValueChange = { lName = it },
                    label = { Text(text = "Last name") },
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(10.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedLabelColor = Color.Gray,
                        unfocusedLabelColor = Color.Gray,
                        containerColor = Color.White
                    )
                )
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "email") },
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(10.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedTextColor = Color.Black,
                        unfocusedTextColor = Color.Black,
                        focusedLabelColor = Color.Gray,
                        unfocusedLabelColor = Color.Gray,
                        containerColor = Color.White
                    )
                )
                val context = LocalContext.current
                Button(
                    onClick = { if(fName.isBlank() || lName.isBlank() || email.isBlank()){
                        Toast.makeText(context,"Registration unsuccessful. Please enter all data.",Toast.LENGTH_SHORT).show()
                    }else{
                        PreferencesHelper.saveUserData(context,fName,lName,email)
                        Toast.makeText(context, "Registration successful!", Toast.LENGTH_SHORT).show()
                        navController.navigate(Screen.homeScreen.rout)
                    } },
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .padding(top = 50.dp),
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(width = 2.dp, color = Color(0xFFfcbd35)),
                    colors = ButtonDefaults.buttonColors(containerColor=Color(0xFFfcd135), contentColor = Color.Black)
                ) {
                    Text(text = "Register")
                }

            }


        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun OnBoardingPreview() {
//    OnBoardingScreen()
//}