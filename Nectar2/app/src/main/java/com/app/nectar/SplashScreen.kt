package com.app.nectar



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.nectar.ui.theme.GreenJC
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    // Delay the splash screen for 3 seconds and then navigate to MainScreen
    LaunchedEffect(Unit) {
        delay(3000L)
        navController.navigate("WelcomeScreen") {
            popUpTo("splash_screen") { inclusive = true }
        }
    }

    // UI for Splash Screen
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(GreenJC) // Set background color
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo Image
            Image(
                painter = painterResource(id = R.drawable.img), // Replace with your actual logo resource
                contentDescription = "Logo",
                modifier = Modifier.size(150.dp) // Adjust size as needed
            )


        }
    }
}

@Composable
fun MainScreen() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Main Screen Content")
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

@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen() {
    MyApp()
}
