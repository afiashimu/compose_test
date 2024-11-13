package com.app.application

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Account() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {
        // Profile Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.propic), // Replace with your profile image resource
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(64.dp)
                    .background(Color.LightGray, shape = CircleShape)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = "Afsar Hossen", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = "lmshuvo97@gmail.com", color = Color.Gray, fontSize = 14.sp)
            }

            //Spacer(modifier = Modifier.weight(1f))

            Icon(
                painter = painterResource(id = R.drawable.ic_p), // Replace with your edit icon resource
                contentDescription = "null",
                modifier = Modifier.size(15.dp),
                tint = Color.Green
            )
        }

        // Menu Options
        MenuItem(icon = R.drawable.orders_icon, title = "Orders")
        MenuItem(icon = R.drawable.details_icon, title = "My Details")
        MenuItem(icon = R.drawable.address, title = "Delivery Address")
        MenuItem(icon = R.drawable.vector_icon, title = "Payment Methods")
        MenuItem(icon = R.drawable.cord_icon, title = "Promo Code")
        MenuItem(icon = R.drawable.bell, title = "Notifications")
        MenuItem(icon = R.drawable.help, title = "Help")
        MenuItem(icon = R.drawable.icon, title = "About")

        Spacer(modifier = Modifier.weight(1f))
     //logout
        val context = LocalContext.current

        Button(
            onClick = {
                // Handle log out action here
                (context as? Activity)?.finishAffinity() // Exits the application
            },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
                .height(58.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE0F7E9))
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_log), // Replace with your logout icon resource
                contentDescription = "Logout",
                tint = Color.Green,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Log Out",
                color = Color.Green, // Green color
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }

    }
}



@Composable
fun MenuItem(icon: Int, title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = title,
            modifier = Modifier.size(24.dp),
            tint = Color.Black
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = title, fontSize = 16.sp, color = Color.Black)
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.ic_forward), // Replace with your forward arrow icon resource
            contentDescription = "Next",
            modifier = Modifier.size(24.dp),
            tint = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAccount() {
    Account()
}
