package com.app.nectar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.application.Login

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MobileNumberInputScreen(navController: NavController) {
    var mobileNumber by remember { mutableStateOf("") }
    // Focus state for the input field
    var isFocused by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
    ) {
        // Back button
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back), // Replace with your back icon
                contentDescription = "Back"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Title
        Text(
            text = "Enter your mobile number",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Mobile number label
        Text(
            text = "Mobile Number",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Country flag and code
            Image(
                painter = painterResource(id = R.drawable.ic_flag), // Replace with your flag drawable resource
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

            // Mobile number input field
            OutlinedTextField(
                value = mobileNumber,
                onValueChange = { mobileNumber = it },

                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged { focusState ->
                        isFocused = focusState.isFocused
                        // Navigate to the next page when focused
                        if (isFocused) {
                            navController.navigate("MobileNumberInputScreen") {
                                // Clear the back stack or pop up to specific destinations
                                popUpTo("Login") { inclusive = false }
                            }
                        }
                    },
                textStyle = androidx.compose.ui.text.TextStyle(
                    fontSize = 18.sp,
                    letterSpacing = 2.sp
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }

        Spacer(modifier = Modifier.height(200.dp))

        // Next button
        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = { /* Handle next action, e.g., navController.navigate("NextScreen") */ },
                modifier = Modifier
                    .size(56.dp)
                    .background(
                        color = Color.Green, // Use a specific green shade, or define your custom color in the theme
                        shape = CircleShape
                    )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_forward), // Replace with your forward icon
                    contentDescription = "Next",
                    tint = Color.White // Optional: Set icon color to white for contrast
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMobileNumberInputScreen() {
    val navController = rememberNavController()
    MobileNumberInputScreen(navController = navController)
}
