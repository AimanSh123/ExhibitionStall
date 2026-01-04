package com.example.exhibitionstall.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.exhibitionstall.ExhibitionViewModel
import com.example.exhibitionstall.model.Category
import com.example.exhibitionstall.ui.components.CategoryChips
import com.example.exhibitionstall.ui.components.SearchBar
import com.example.exhibitionstall.ui.components.StallList

// Bottom navigation item
data class BottomNavItem(
    val title: String,
    val route: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: ExhibitionViewModel,
    navController: NavHostController
) {
    val stalls by viewModel.stalls.collectAsState()
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf(Category.ALL) }

    // Bottom navigation items
    val bottomItems = listOf(
        BottomNavItem("Cart", "cart", Icons.Default.ShoppingCart),
        BottomNavItem("Orders", "orders", Icons.Default.List)
    )
    var currentRoute by remember { mutableStateOf("home") }

    // Filter stalls
    val filteredStalls = stalls.filter { stall ->
        val matchesCategory =
            selectedCategory == Category.ALL || stall.category == selectedCategory
        val matchesSearch =
            searchQuery.isBlank() || stall.name.contains(searchQuery, ignoreCase = true)
        matchesCategory && matchesSearch
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Exhibition Stalls") },
                actions = {
                    IconButton(onClick = { navController.navigate("profile") }) {
                        Icon(Icons.Default.Person, contentDescription = "Profile")
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar {
                bottomItems.forEach { item ->
                    NavigationBarItem(
                        selected = currentRoute == item.route,
                        onClick = {
                            currentRoute = item.route
                            navController.navigate(item.route)
                        },
                        icon = { Icon(item.icon, contentDescription = item.title) },
                        label = { Text(item.title) }
                    )
                }
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(12.dp))

            // 🔍 Search bar
            SearchBar(initialQuery = searchQuery) { keyword ->
                searchQuery = keyword
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 🏷 Category chips
            CategoryChips(
                selectedCategory = selectedCategory,
                onCategorySelected = { category ->
                    selectedCategory = category
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 🏪 Stall list
            StallList(
                stalls = filteredStalls,
                onViewStallClick = { stallId ->
                    navController.navigate("stall/$stallId")
                }
            )

            if (filteredStalls.isEmpty()) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "No stalls found",
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            // Extra space so bottom bar doesn't overlap
            Spacer(modifier = Modifier.height(72.dp))
        }
    }
}