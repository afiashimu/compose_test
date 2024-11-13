package com.app.application

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.application.ui.theme.Blue57
import com.app.application.ui.theme.Blue58

@Composable
fun Login() {
    var mobileNumber by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_mask),
            contentDescription = "Login image",
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
                .align(Alignment.TopCenter)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(390.dp))

        // Title Text
        Text(
            text = "Get your groceries\nwith nectar",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(18.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(460.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            // Flag icon
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
                placeholder = { Text("Enter mobile number") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                visualTransformation = VisualTransformation.None,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            // Divider Text
            Text(
                text = "Or connect with social media",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }

    Spacer(modifier = Modifier.height(24.dp))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 440.dp)
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Google Button
        Button(
            onClick = { /* Handle Google Login */ },
            colors = ButtonDefaults.buttonColors(containerColor = Blue57),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.google), // Replace with your Google icon
                    contentDescription = "Google Icon",
                    modifier = Modifier.size(200.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))
               
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Facebook Button
        Button(
            onClick = { /* Handle Facebook Login */ },
            colors = ButtonDefaults.buttonColors(containerColor = Blue58),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = R.drawable.fb), // Replace with your Facebook icon
                    contentDescription = "Facebook Icon",
                    modifier = Modifier.size(200.dp)
                )
                Spacer(modifier = Modifier.width(20.dp))

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLogin() {
    Login()
}
