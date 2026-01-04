package com.example.exhibitionstall.ui

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import com.example.exhibitionstall.ExhibitionViewModel
import com.example.exhibitionstall.ui.auth.AuthViewModel
import com.example.exhibitionstall.ui.auth.AuthState
import com.example.exhibitionstall.ui.screens.*

@Composable
fun ExhibitionStallApp() {
    val navController = rememberNavController()
    val viewModel: ExhibitionViewModel = viewModel()
    val authViewModel: AuthViewModel = viewModel()

    val authState by authViewModel.authState.collectAsState()

    NavHost(navController, startDestination = when (authState) {
        AuthState.REGISTER -> "register"
        AuthState.LOGIN -> "login"
        AuthState.HOME -> "home"
        else -> "login"
    }) {
        composable("register") {
            RegisterScreen(
                authViewModel = authViewModel,
                navToLogin = { navController.navigate("login") { popUpTo("register") { inclusive = true } } }
            )
        }

        composable("login") {
            LoginScreen(
                authViewModel = authViewModel,
                navToRegister = { navController.navigate("register") },
                navToHome = { navController.navigate("home") { popUpTo("login") { inclusive = true } } }
            )
        }


    // 🏠 Home screen with bottom navigation
        composable("home") {
            HomeScreen(
                viewModel = viewModel,
                navController = navController
            )
        }

        // 🏬 Stall Details
        composable("stall/{stallId}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("stallId")?.toInt() ?: 0
            StallDetailsScreen(
                stallId = id,
                viewModel = viewModel,
                onBack = { navController.popBackStack() },
                onGoToCart = { navController.navigate("cart") }
            )
        }

        // 🛒 Cart
        composable("cart") {
            CartScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() },
                onPlaceOrder = { navController.navigate("orders") }
            )
        }

        // 📦 Orders
        composable("orders") {
            OrdersScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }

        // 👤 Profile
        composable("profile") {
            ProfileScreen(
                authViewModel = authViewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}