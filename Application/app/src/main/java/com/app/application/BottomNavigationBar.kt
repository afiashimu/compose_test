package com.app.application

import Shop
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

sealed class BottomNavItem(val route: String, val title: String, val icon: Int) {
    object Shop : BottomNavItem("shop", "Shop", R.drawable.ic_shop)
    object Explore : BottomNavItem("explore", "Explore", R.drawable.ic_explore)
    object Cart : BottomNavItem("cart", "Cart", R.drawable.ic_cart)
    object Favourite : BottomNavItem("favourite", "Favourite", R.drawable.ic_favourite)
    object Account : BottomNavItem("account", "Account", R.drawable.ic_account)
}

// MainScreen Composable with Bottom Navigation and NavHost
@Composable
fun BootomNavigationBar() {
    val navController = rememberNavController()



    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Shop.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(BottomNavItem.Shop.route) { Shop() }
            composable(BottomNavItem.Explore.route) { Explore() }
            composable(BottomNavItem.Cart.route) { Cart() }
            composable(BottomNavItem.Favourite.route) { Favourite() }
            composable(BottomNavItem.Account.route) { Account() }

        }
    }
}

// BottomNavigationBar Composable
@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Shop,
        BottomNavItem.Explore,
        BottomNavItem.Cart,
        BottomNavItem.Favourite,
        BottomNavItem.Account

    )

    NavigationBar(
        containerColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(painter = painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(item.title) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBootomNavigationBar() {
    BootomNavigationBar()
}
