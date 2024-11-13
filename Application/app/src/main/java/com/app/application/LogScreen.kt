package com.app.application

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.application.ui.theme.GreenJC

@Composable
fun LogScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        //.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Spacer(modifier = Modifier.height(40.dp))

        // Placeholder for the top image

//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp) // Adjust height as needed
//        ) {
        // Image positioned at the top right
        Image(
            painter = painterResource(id = R.drawable.ic_mask), // Replace with your image resource
            contentDescription = "Top Right Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp) // Adjust height as needed
                //.align(Alignment.TopEnd)
                .offset(x = 140.dp, y = 0.dp) // Adjust offset as needed for positioning
        )
        Column (

            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .background(Color.White)
                .padding(start = 10.dp)
        ){
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Loging", // Change to "Login" if needed
            style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.Black),

            )


            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Enter your emails and password",
                style = TextStyle(fontSize = 16.sp, color = Color.Gray)
            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        val visibilityIcon =
                            if (passwordVisible) R.drawable.ic_visibility_off else R.drawable.ic_eye_24
                        Icon(
                            painterResource(id = visibilityIcon),
                            contentDescription = "Toggle Password Visibility"
                        )

                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth()
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Forgot Password?",
                style = TextStyle(color = Color.Gray, fontSize = 14.sp),
                modifier = Modifier.align(Alignment.End)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Get Started Button
            Button(
                onClick = { /* Navigate to next screen */ },
                colors = ButtonDefaults.buttonColors(containerColor = GreenJC),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .padding(horizontal = 24.dp)
                    .padding(bottom = 10.dp)

            ) {
                Text(text = "Log in", color = Color.White, fontSize = 18.sp)


            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Don't have an account?",
                    style = TextStyle(color = Color.Gray, fontSize = 14.sp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Singup?",
                    style = TextStyle(color = Color.Green, fontSize = 14.sp)
                )

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewLogScreen() {
    LogScreen()
}

