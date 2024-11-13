package com.app.application

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.app.nectar.R
import com.app.nectar.ui.theme.Blue57
import com.app.nectar.ui.theme.Blue58

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(navController: NavController) {
    var mobileNumber by remember { mutableStateOf("") }
    var isFocused by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.ic_mask),
            contentDescription = "Login image",
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
                .align(Alignment.TopCenter)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(340.dp))

            // Title Text
            Text(
                text = "Get your groceries\nwith nectar",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Start)
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Phone Number Input
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Flag icon
                Image(
                    painter = painterResource(id = R.drawable.ic_flag),
                    contentDescription = "Bangladesh Flag",
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "+880",
                    fontSize = 18.sp,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Phone number input field
                TextField(
                    value = mobileNumber,
                    onValueChange = { input ->
                        // Ensure input is numeric and at most 10 digits
                        if (input.length <= 10 && (input.length != 2 || input[0] == '1')) {
                            mobileNumber = input
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged { focusState ->
                            isFocused = focusState.isFocused
                            // Navigate if focused and mobileNumber length is 10
                            if (isFocused && mobileNumber.length == 10) {
                                navController.navigate("MobileNumberInputScreen") {
                                    popUpTo("LoginScreen") { inclusive = false }
                                }
                            }
                        },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Gray,
                        unfocusedIndicatorColor = Color.LightGray
                    )
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Or connect with social media",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Social Media Buttons
            SocialMediaButtons()
        }
    }
}

@Composable
fun SocialMediaButtons() {
    Button(
        onClick = { /* Handle Google Login */ },
        colors = ButtonDefaults.buttonColors(containerColor = Blue57),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google Icon",
                modifier = Modifier.size(200.dp)
            )

        }
    }

    Spacer(modifier = Modifier.height(8.dp))

    Button(
        onClick = { /* Handle Facebook Login */ },
        colors = ButtonDefaults.buttonColors(containerColor = Blue58),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.fb),
                contentDescription = "Facebook Icon",
                modifier = Modifier.size(200.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLogin() {
    val mockNavController = androidx.navigation.compose.rememberNavController()
    Login(navController = mockNavController)
}
