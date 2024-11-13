package com.app.application


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.app.application.BakeryScreen.BakeryScreen
import com.app.application.BeveragesScreen.BeveragesScreen
import com.app.application.CookingScreen.CookingScreen
import com.app.application.DairyScreen.DairyScreen
import com.app.application.FreshScreen.FreshScreen
import com.app.application.MeatScreen.MeatScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Explore() {
    var selectedCategory by remember { mutableStateOf<String?>(null) }

    if (selectedCategory != null) {

        when (selectedCategory) {
            "Beverages" -> BeveragesScreen()
            "Fresh Fruits & Vegetable" -> FreshScreen()
            "Cooking Oil & Ghee" -> CookingScreen()
            "Meat & Fish" -> MeatScreen()
            "Bakery & Snacks" -> BakeryScreen()
            "Dairy & Eggs" -> DairyScreen()
            else -> Text("Category not found")
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = "Find Products",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Search Store") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "Search Icon",
                        tint = Color.Gray
                    )
                },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    containerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            ProductCategoryGrid { category ->
                selectedCategory = category
            }
        }
    }
}

@Composable
fun ProductCategoryGrid(onCategoryClick: (String) -> Unit) {
    // Define each category with its title, background color, and image resource ID
    val categories = listOf(
        Triple("Fresh Fruits & Vegetable", Color(0xFFE8F5E9), R.drawable.food),
        Triple("Cooking Oil & Ghee", Color(0xFFFFF3E0), R.drawable.pngfuel),
        Triple("Meat & Fish", Color(0xFFFFEBEE), R.drawable.meat),
        Triple("Bakery & Snacks", Color(0xFFEDE7F6), R.drawable.pn),
        Triple("Dairy & Eggs", Color(0xFFF1F8E9), R.drawable.ic_egg),
        Triple("Beverages", Color(0xFFE3F2FD), R.drawable.bavera)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(categories.size) { index ->
            val (title, backgroundColor, imageResId) = categories[index]
            CategoryCard(
                title = title,
                backgroundColor = backgroundColor,
                imageResId = imageResId,
                onClick = { onCategoryClick(title) }
            )
        }
    }
}

@Composable
fun CategoryCard(title: String, backgroundColor: Color, imageResId: Int, onClick: () -> Unit) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .height(220.dp)
            .fillMaxWidth()
            .background(backgroundColor, RoundedCornerShape(16.dp))
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )
        }
    }
}

@Preview
@Composable
fun PreviewProductCategoryScreen() {
    Explore()
}
