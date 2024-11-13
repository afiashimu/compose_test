package com.app.application

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.application.ui.theme.GreenJC

@Composable
fun WelcomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Background Image
        Image(
            painter = painterResource(id = R.drawable.img_3), // Replace with your background image resource
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize()
        )

        // Content Overlay
       Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
           Spacer(modifier = Modifier.height(100.dp))
            // Icon and Welcome Text
            Image(
                painter = painterResource(id = R.drawable.img_1), // Replace with your icon resource
                contentDescription = "Carrot Icon",
                modifier = Modifier.size(48.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Welcome\nto our store",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                lineHeight = 36.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Get your groceries in as fast as one hour",
                fontSize = 16.sp,
                color = Color.White
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
                    .padding(horizontal = 32.dp)
                    .padding(bottom = 10.dp)

            ) {
                Text(text = "Get Started", color = Color.White, fontSize = 18.sp)


            }
           Spacer(modifier = Modifier.height(60.dp))
        }
    }
}
    @Preview(showBackground = true)
    @Composable
    fun PreviewWelcomeScreen() {
        WelcomeScreen()
    }






