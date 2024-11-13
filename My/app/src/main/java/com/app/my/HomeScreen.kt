package com.app.my

import androidx.compose.foundation.Image

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        bottomBar = { BottomNavbar() },
        content = {
            Box(
                modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                Column(
                    modifier
                        .fillMaxWidth()
                        .padding(top = 50.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.g),
                        contentDescription = "Carrot image",
                        modifier
                            .size(40.dp)
                            .background(color = Color.Green)
                    )
                    Spacer(modifier.height(15.dp))

                    Row(
                        modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Location icon",
                            modifier.size(30.dp)
                        )

                        Spacer(modifier.width(3.dp))

                        Text(
                            text = "Dhaka, Banasree",
                            fontSize = 18.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF4C4F4D)
                        )
                    }

                    SearchBarComponent()
                    Spacer(modifier.height(20.dp))

                    Image(
                        painter = painterResource(id = R.drawable.g),
                        contentDescription = "",
                        modifier
                            .height(130.dp)
                            .padding(10.dp),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier.height(10.dp))
                    OfferSection()
                    Spacer(modifier.height(20.dp))
                    Spacer(modifier.height(20.dp))
                    SellingSection()
                    Spacer(modifier.height(20.dp))
                    GroceriesSection()
                }
            }

        }
    )

}

@Composable
fun OfferSection(modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Exclusive offer",
            fontSize = 24.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF181725)
        )
        Text(
            text = "See all",
            fontSize = 18.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF53b175)
        )
    }
    Spacer(modifier.height(10.dp))
    RowImageList()
}

@Composable
fun SellingSection(modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Best Selling",
            fontSize = 24.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF181725)
        )
        Text(
            text = "See all",
            fontSize = 18.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF53b175)
        )
    }
    Spacer(modifier.height(10.dp))
    RowImageList()
}
@Composable
fun GroceriesSection(modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Groceries",
            fontSize = 24.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF181725)
        )
        Text(
            text = "See all",
            fontSize = 18.sp,
            fontWeight = FontWeight(600),
            color = Color(0xFF53b175)
        )
    }
    Spacer(modifier.height(10.dp))
    RowImageList()
    Spacer(modifier.height(10.dp))
    RowImageList()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarComponent(modifier: Modifier = Modifier) {
    var textState by remember { mutableStateOf("") }
    var activeState by remember { mutableStateOf(false) }

    SearchBar(
        query = textState,
        onQueryChange = { textState = it },
        onSearch = { activeState = false },
        active = activeState,
        onActiveChange = { activeState = it },
        modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        placeholder = {
            Text(
                text = "Search Store",
                fontSize = 20.sp,
                fontWeight = FontWeight(600)
            )
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
        },
        shape = SearchBarDefaults.fullScreenShape

    ) { }

}


@Composable
fun RowImageList(modifier: Modifier = Modifier) {
    val imageList = listOf(
        R.drawable.g,
        R.drawable.g,
        R.drawable.g,
        R.drawable.g,
        R.drawable.g,
        R.drawable.g,
        R.drawable.g

    )
    LazyRow(
        modifier
            .padding(10.dp)
            .fillMaxWidth()) {
        items(imageList.size) {
            Column(modifier.padding(5.dp)) {

                Card(
                    modifier.width(180.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                    shape = RoundedCornerShape(25.dp)
                ) {

                    Box(modifier.fillMaxWidth()) {
                        Column(modifier.fillMaxWidth()) {
                            Spacer(Modifier.height(8.dp))
                            Image(
                                painter = painterResource(id = imageList[it]),
                                contentDescription = "",
                                modifier
                                    .size(70.dp)
                                    .align(Alignment.CenterHorizontally)
                            )

                            Spacer(Modifier.height(8.dp))
                            Text(
                                modifier = modifier.padding(start = 8.dp),
                                text = "Organic Fruit",
                                fontWeight = FontWeight(600),
                                fontSize = 18.sp,
                                color = Color(0xFF181725),
                                textAlign = TextAlign.Start
                            )

                            Spacer(Modifier.height(8.dp))
                            Text(
                                modifier = modifier.padding(start = 8.dp),
                                text = "7 Pcs, Pricing",
                                fontWeight = FontWeight(600),
                                fontSize = 16.sp,
                                color = Color(0xFF181725),
                                textAlign = TextAlign.Start
                            )

                            Spacer(Modifier.height(8.dp))
                            Row(
                                modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    modifier = modifier,
                                    text = "$4.99",
                                    fontWeight = FontWeight(600),
                                    fontSize = 16.sp,
                                    color = Color(0xFF181725),
                                    textAlign = TextAlign.Start
                                )


                                FloatingActionButton(

                                    modifier = Modifier.size(50.dp,50.dp),

                                    onClick = {},
                                    containerColor = Color(0xFF53b175),
                                    contentColor = Color(0xFFfcfcfc)

                                ) {
                                    Icon(imageVector = Icons.Default.Add, contentDescription = "")
                                }
                            }
                            Spacer(Modifier.height(10.dp))
                        }
                    }
                }


            }
        }
    }

}

@Composable

fun BottomNavbar(modifier: Modifier = Modifier) {
    var selectIndex by remember { mutableStateOf(0) }

    data class NavbarContent(
        val route: String,
        var label: String,
        var icon: ImageVector,
        var badgeCount: Int? = null,
    )

    var navBarList = listOf(

        NavbarContent(
            route = "home",
            label = "Home",
            icon = Icons.Default.Home,
        ),

        NavbarContent(
            route = "settings",
            label = "Settings",
            icon = Icons.Default.Settings
        ),

        NavbarContent(
            route = "Search",
            label = "Search",
            icon = Icons.Default.Search
        )
    )
    NavigationBar(modifier.fillMaxWidth()) {

        navBarList.forEachIndexed { index, navItem ->

            NavigationBarItem(selected = index == selectIndex,
                onClick = { selectIndex = index },
                modifier = Modifier,

                label = { Text(text = navItem.label) },
                icon = {

                    Icon(imageVector = navItem.icon, contentDescription = "Image icon")
                })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
