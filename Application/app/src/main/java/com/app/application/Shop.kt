import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.app.application.DataClass.CarouselItem
import com.app.application.DataClass.Item
import com.app.application.R


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun Shop() {
    val carouselItems = listOf(
        CarouselItem("Meat", R.drawable.ic_meat),
        CarouselItem("Egg", R.drawable.ic_egg),
        CarouselItem("Food", R.drawable.food),
        CarouselItem("Pepsi", R.drawable.pepsi),
        CarouselItem("Dairy", R.drawable.img_o)
    )

    val item = listOf(
        Item("Product 1", "Description 1", "$10", R.drawable.egg_noodle),
        Item("Product 2", "Description 2", "$15", R.drawable.food),
        Item("Product 3", "Description 3", "$20", R.drawable.pngfuel),
        Item("Product 4", "Description 4", "$25", R.drawable.img_o),
        Item("Product 5", "Description 5", "$30", R.drawable.diet_coke),
        Item("Product 2", "Description 2", "$15", R.drawable.food),
        Item("Product 3", "Description 3", "$20", R.drawable.pngfuel),
        Item("Product 4", "Description 4", "$25", R.drawable.img_o),
        Item("Product 5", "Description 5", "$30", R.drawable.diet_coke)
    )

    // Define what happens when the 'See all' text is clicked
    val onSeeAllClick: () -> Unit = {
        // Handle the action when the "See all" button is clicked
        println("See all clicked")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top Image Icon
        Image(
            painter = painterResource(id = R.drawable.ic_g),
            contentDescription = "Login image",
            modifier = Modifier.size(30.dp)
        )

        // Location Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = "Location",
                tint = Color.Black
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Dhaka, Banassre", fontSize = 16.sp, fontWeight = FontWeight.Medium)
        }

        // Search Bar
        Spacer(modifier = Modifier.width(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start
        ) {
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
        }


        Spacer(modifier = Modifier.height(16.dp))

        // Carousel Section
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(carouselItems) { item ->
                CategoryCard(item)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Exclusive Offer Section
        SectionHeader(title = "Exclusive Offer", showAll = false, onSeeAllClick = onSeeAllClick)
        Column(

        ){
            Spacer(modifier = Modifier.height(16.dp))

            // Carousel Section
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(carouselItems) { item ->
                    CategoryCard(item)
                }
            }

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(item) { item ->
                ProductCard(product = item)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))


    }
}
}


@Composable
fun SectionHeader(title: String, showAll: Boolean, onSeeAllClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = if (showAll) "See less" else "See all",
            fontSize = 16.sp,
            color = Color(0xFF4CAF50),
            modifier = Modifier.clickable { onSeeAllClick() }
        )
    }
}



// Composable function for Product Card
@Composable
fun ProductCard(product: Item) {
    Box(
        modifier = Modifier
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .border(1.dp, Color.LightGray, shape = RoundedCornerShape(8.dp))
            .clickable { /* Handle product click */ }
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                modifier = Modifier
                    .size(80.dp)
                    .padding(top = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = product.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = product.description,
                fontSize = 14.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = product.price,
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
                IconButton(
                    onClick = { /* Handle add to cart click */ },
                    modifier = Modifier
                        .size(30.dp)
                        .background(Color(0xFF4CAF50), shape = RoundedCornerShape(50))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.add), // Use a "+" icon drawable
                        contentDescription = "Add to cart",
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun CategoryCard(category: CarouselItem) {
    Box(
        modifier = Modifier
            .size(180.dp, 100.dp)
            .background(Color(0xFFF1F1F1), shape = RoundedCornerShape(12.dp))
            .clickable { /* Handle category click */ }
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,

        ) {
            Image(
                painter = painterResource(id = category.imageRes),
                contentDescription = category.title,
                modifier = Modifier.size(110.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = category.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewShop() {
    Shop()
}