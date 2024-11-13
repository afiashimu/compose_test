package com.app.application

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CheckoutSection(cartItems: List<String>, totalCost: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF7F7F7), RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Checkout", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { /* Close the bottom sheet */ }) {
                Icon(Icons.Default.Clear, contentDescription = "Close")
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Displaying Cart Items
        cartItems.forEach {
            CheckoutOptionRow("Item", it)
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Displaying Total Cost
        CheckoutOptionRow("Total Cost", totalCost)

        Spacer(modifier = Modifier.height(8.dp))

        // Additional checkout options
        CheckoutOptionRow("Delivery", "Select Method")
        CheckoutOptionRow("Payment", "Pick method")
        CheckoutOptionRow("Promo Code", "Pick discount")

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "By placing an order you agree to our Terms and Conditions.",
            fontSize = 12.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun CheckoutOptionRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = label, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.weight(1f))
        Text(text = value, fontSize = 14.sp, fontWeight = FontWeight.Medium)
    }
}
