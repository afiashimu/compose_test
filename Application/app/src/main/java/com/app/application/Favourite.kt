package com.app.application

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import com.app.application.DataClass.Item

@Composable
fun Favourite() {
    val items = listOf(
        Item("Sprite Can", "325ml, Price", "$1.50", R.drawable.sprite),
        Item("Diet Coke", "355ml, Price", "$1.99", R.drawable.diet_coke),
        Item("Apple & Grape Juice", "2L, Price", "$15.50", R.drawable.apple_grape),
        Item("Coca Cola Can", "325ml, Price", "$4.99", R.drawable.coca_cola),
        Item("Pepsi Can", "330ml, Price", "$4.99", R.drawable.pepsi),
        Item("Diet Coke", "355ml, Price", "$1.99", R.drawable.orange_juice),
        Item("Apple & Grape Juice", "2L, Price", "$15.50", R.drawable.apple_grape),
        Item("Coca Cola Can", "325ml, Price", "$4.99", R.drawable.diet_coke),
        Item("Pepsi Can", "330ml, Price", "$4.99", R.drawable.pepsi)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Favourite",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally)
        )

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(items.size) { index ->
                FavoriteItemRow(items[index])
            }
        }

        AddToCartButton()
    }
}

@Composable
fun FavoriteItemRow(favoriteItem: Item) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = favoriteItem.imageRes),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = favoriteItem.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = favoriteItem.description, color = Color.Gray, fontSize = 14.sp)
        }

        Text(text = favoriteItem.price, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            painter = painterResource(id = R.drawable.ic_forward),
            contentDescription = "Next",
            modifier = Modifier.size(24.dp),
            tint = Color.Gray
        )
    }
}

@Composable
fun AddToCartButton() {
    Button(
        onClick = { /* Handle add to cart */ },
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00C569))
    ) {
        Text(
            text = "Add All To Cart",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Preview
@Composable
fun PreviewFavourite() {
    Favourite()
}
