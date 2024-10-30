package com.app.application

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    // Delay the splash screen for 2 seconds and then navigate to MainScreen
    LaunchedEffect(Unit) {
        delay(2000L)
        navController.navigate("main_screen") {
            popUpTo("splash_screen") { inclusive = true }
        }
    }

    // UI for Splash Screen
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
    ) {
        // Place your splash content here, like an Image or Text
    }
}

@Composable
fun MainScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        // Your main screen content goes here
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "splash_screen") {
        composable("splash_screen") { SplashScreen(navController) }
        composable("main_screen") { MainScreen() }
    }
}
