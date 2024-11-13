package com.app.application

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen( navController: NavController){

    var email by remember {
        mutableStateOf(value = "")
    }

    var password by remember {
        mutableStateOf(value = "")
    }

    Column (
        modifier = Modifier.fillMaxSize( ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_fst), contentDescription = "Login image",
            modifier = Modifier.size(300.dp)
        )
        Text(text = "Login", fontSize = 30.sp, fontWeight = FontWeight.Bold)


        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Login or sing in your account")

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(value = email, onValueChange = {
            email =it}, label = {
            Text(text = "Email address")
        })

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(value = password, onValueChange = {
            password =it
        }, label = {
            Text(text = "Password")
        } ,  visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(15.dp))
        Button(onClick = {
            navController.navigate("Home_Screen")
            Log.i("Credential","Email : $email Password: $password")

        }) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(12.dp))


            TextButton(onClick = {}) {
                Text(text = "Forget Password ")
            }
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "or Create Your Account" , modifier = Modifier.clickable { })
Row(
    modifier = Modifier.fillMaxWidth().padding(40.dp),
    horizontalArrangement = Arrangement.SpaceEvenly
) {
    Image(painter = painterResource(id = R.drawable.ic_fb),
        contentDescription = "Facebook",
        modifier = Modifier.size(60.dp)
            .clickable {  }
    )

    Image(painter = painterResource(id = R.drawable.ic_google),
        contentDescription = "Google",
        modifier = Modifier.size(60.dp)
            .clickable {  }
    )

    Image(painter = painterResource(id = R.drawable.ic_twitter),
        contentDescription = "Twitter",
        modifier = Modifier.size(60.dp)
            .clickable {  }
    )



}



        }


    }

