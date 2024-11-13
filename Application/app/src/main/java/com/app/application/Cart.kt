package com.app.application

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.application.DataClass.Item
import kotlinx.coroutines.launch

@Composable
fun Cart() {
    val items = listOf(
        Item("Bell Pepper Red", "1kg, Price", "$4.99", R.drawable.ic_egg),
        Item("Egg Chicken Red", "4pcs, Price", "$1.99", R.drawable.egg_noodle),
        Item("Organic Bananas", "12kg, Price", "$3.00", R.drawable.food),
        Item("Bell Pepper Red", "1kg, Price", "$4.99", R.drawable.img_o),
        Item("Egg Chicken Red", "4pcs, Price", "$1.99", R.drawable.ic_egg),
        Item("Organic Bananas", "12kg, Price", "$3.00", R.drawable.pngfuel),
        Item("Bell Pepper Red", "1kg, Price", "$4.99", R.drawable.meat),
        Item("Egg Chicken Red", "4pcs, Price", "$1.99", R.drawable.ic_g),
        Item("Organic Bananas", "12kg, Price", "$3.00", R.drawable.ic_meat),
        Item("Ginger", "250gm, Price", "$2.99", R.drawable.ic_g)
    )
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "My Cart",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items.size) { index ->
                    CartItemRow(items[index])
                }
            }

            CheckoutButton(totalPrice = "$12.96")
        }
    }
}

@Composable
fun CartItemRow(cartItem: Item) {
    var quantity by remember { mutableStateOf(1) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = cartItem.imageRes),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = cartItem.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = cartItem.description, color = Color.Gray, fontSize = 14.sp)
        }

        Text(text = cartItem.price, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.width(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color(0xFFF0F0F0), RoundedCornerShape(8.dp))
                .padding(horizontal = 8.dp)
        ) {
            IconButton(onClick = { if (quantity > 1) quantity-- }) {
                Icon(
                    painter = painterResource(id = R.drawable.remove),
                    contentDescription = "Decrease",
                    modifier = Modifier.size(24.dp)
                )
            }
            Text(text = quantity.toString(), fontWeight = FontWeight.Bold)
            IconButton(onClick = { quantity++ }) {
                Icon(
                    painter = painterResource(id = R.drawable.add),
                    contentDescription = "Increase",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }
}

@Composable
fun CheckoutButton(totalPrice: String) {
    Button(
        onClick = { /* Handle checkout */ },
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00C569))
    ) {
        Text(
            text = "Go to Checkout",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text = totalPrice,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}





@Preview
@Composable
fun PreviewCart() {
    Cart()
}
