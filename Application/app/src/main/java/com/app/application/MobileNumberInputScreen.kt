package com.app.application

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MobileNumberInputScreen() {
    var mobileNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White)
    ) {
        // Back button
        IconButton(onClick = { /* Handle back press */ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_back), // Replace with your back icon
                contentDescription = "White"
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
            Box(
                modifier = Modifier
                  //  .size(36.dp)
                   // .clip(CircleShape)

            ) {
                // Flag icon
                Image(
                    painter = painterResource(id = R.drawable.ic_flag), // Replace with your flag drawable resource
                    contentDescription = "Bangladesh Flag",
                    modifier = Modifier.size(24.dp)
                )
            }

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

        Spacer(modifier = Modifier.height(200.dp))

        // Next button
        Box(
            contentAlignment =  Alignment.BottomEnd,
            modifier = Modifier.fillMaxWidth()

        ) {
            IconButton(
                onClick = { /* Handle next action */ },
                modifier = Modifier
                    .size(56.dp)
                    .background(
                        color = Color.Green, // Use a specific green shade, or define your custom color in the theme
                        shape = CircleShape
                    )
                    .clip(CircleShape)
            )
            {
                Icon(
                    painter = painterResource(id = R.drawable.ic_back), // Replace with your forward icon
                    contentDescription = "Next",
                    tint = Color.White // Optional: Set icon color to white for contrast
                )
            }
        }
    }


}

@Preview
@Composable
fun PreviewMobileNumberInputScreen() {
    MobileNumberInputScreen()
}
