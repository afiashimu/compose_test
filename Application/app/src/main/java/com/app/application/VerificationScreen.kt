package com.app.application



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
fun VerificationScreen() {
    var verifiCode by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)
            .background(Color.White)
            .padding(start = 10.dp)

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
            text = "Enter your 4-digit code",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Mobile number label
        Text(
            text = "Code",
            fontSize = 14.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,

            modifier = Modifier.fillMaxWidth()
                .padding(start = 6.dp)
        ) {
            // Country flag and code
            Box(
                modifier = Modifier
             //  .size(36.dp)
               .clip(CircleShape)

            )
            Spacer(modifier = Modifier.width(8.dp))

            // Mobile number input field
            OutlinedTextField(
                value = verifiCode,
                onValueChange = { verifiCode = it },
                placeholder = { Text("- - - -") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                visualTransformation = VisualTransformation.None,
                modifier = Modifier
                    .padding(8.dp)
                   .weight(1f)
                    .fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(180.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
           // modifier = Modifier.padding(start = 8.dp) // Adjust the padding to move it right
        ) {
            Text(
                text = "Resend Code",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(start = 8.dp) // Shift text further to the right
            )

            // Next button
            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(
                    onClick = { /* Handle next action */ },
                    modifier = Modifier
                        .size(56.dp)
                        .background(
                            color = Color.Green, // Use a specific green shade or define your custom color in the theme
                            shape = CircleShape
                        )
                        .clip(CircleShape)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_back), // Replace with your forward icon
                        contentDescription = "Next",
                        tint = Color.White
                    )
                }
            }
        }

    }
        }



@Preview
@Composable
fun PreviewVerificationScreen() {
    VerificationScreen()
}
