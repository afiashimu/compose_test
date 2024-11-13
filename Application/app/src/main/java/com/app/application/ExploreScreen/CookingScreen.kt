package com.app.application.CookingScreen


import android.util.Log
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.app.application.FilterScreen
import com.app.application.R

@Composable
fun CookingScreen() {

    val items = listOf(
        Item("Diet Coke", "325ml, Price", "$1.50", R.drawable.diet_coke),
        Item("Sprite Can", "355ml, Price", "$1.99", R.drawable.sprite),
        Item("Apple & Grape Juice", "2L, Price", "$15.50", R.drawable.apple_grape),
        Item("Orange Juice", "325ml, Price", "$4.99", R.drawable.orange_juice),
        Item("Coca Cola Can", "330ml, Price", "$4.99", R.drawable.coca_cola),
        Item("Pepsi Can", "355ml, Price", "$1.99", R.drawable.pepsi),
        Item("Orange Juice", "325ml, Price", "$4.99", R.drawable.orange_juice),
        Item("Coca Cola Can", "330ml, Price", "$4.99", R.drawable.coca_cola),
        Item("Sprite Can", "355ml, Price", "$1.99", R.drawable.sprite),
        Item("Pepsi Can", "355ml, Price", "$1.99", R.drawable.pepsi)
    )


    // Handle back press
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    // State to show or hide the FilterScreen
    val showFilterScreen = remember { mutableStateOf(false) }

    // Display FilterScreen as a modal when state is true
    Box(modifier = Modifier.fillMaxSize()) {
        // Main content of the CookingScreen

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .padding(top = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.back_arrow),
                contentDescription = "Back",
                modifier = Modifier
                    .size(28.dp)
                    .clickable { onBackPressedDispatcher?.onBackPressed() },
                tint = Color.Black
            )

            Text(
                text = "Coking Oil & Ghee",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = "Filter",
                modifier = Modifier
                    .size(28.dp)
                    .clickable {
                        showFilterScreen.value = true
                        Log.d("FilterScreen", "Filter icon clicked, showFilterScreen: ${showFilterScreen.value}")
                    },
                tint = Color.Black
            )

        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items.size) { index ->
                ProductItem(items[index])
            }
        }
    }

        // Display FilterScreen if the state is true
        if (showFilterScreen.value) {
            FilterScreen(onDismiss = { showFilterScreen.value = false })
        }
    }
}


@Composable
fun ProductItem(product: Item) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray, shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.name,
            modifier = Modifier
                .size(80.dp)
                .padding(8.dp)
        )
        Text(
            text = product.name,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = product.description,
            fontSize = 12.sp,
            color = Color.Gray
        )
        Text(
            text = product.price,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Preview
@Composable
fun PreviewCookingScreen() {
    CookingScreen()
}