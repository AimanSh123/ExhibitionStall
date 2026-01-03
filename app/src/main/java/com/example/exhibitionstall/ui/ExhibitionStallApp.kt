package com.example.exhibitionstall.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.exhibitionstall.ExhibitionViewModel
import com.example.exhibitionstall.ui.screens.HomeScreen
import com.example.exhibitionstall.ui.screens.OrdersScreen
import com.example.exhibitionstall.ui.screens.StallDetailsScreen

@Composable
fun ExhibitionStallApp() {
    val navController = rememberNavController()
    val viewModel: ExhibitionViewModel = viewModel()

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen(
                viewModel = viewModel,
                onStallClick = { stallId ->
                    navController.navigate("stall/$stallId")
                },
                onOrdersClick = {
                    navController.navigate("orders")
                }
            )
        }

        composable("stall/{stallId}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("stallId")?.toInt() ?: 0

            StallDetailsScreen(
                stallId = id,
                viewModel = viewModel,
                onBack = {
                    navController.navigate("home") {
                        popUpTo("home") { inclusive = true }
                        launchSingleTop = true
                    }
                }
            )
        }

        // ✅ Orders screen
        composable("orders") {
            OrdersScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
