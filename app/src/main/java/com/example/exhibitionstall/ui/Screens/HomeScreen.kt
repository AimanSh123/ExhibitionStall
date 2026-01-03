package com.example.exhibitionstall.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.exhibitionstall.ExhibitionViewModel
import com.example.exhibitionstall.model.Category
import com.example.exhibitionstall.ui.components.CategoryChips
import com.example.exhibitionstall.ui.components.SearchBar
import com.example.exhibitionstall.ui.components.StallList
import com.example.exhibitionstall.ui.components.TopNavBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: ExhibitionViewModel,
    onStallClick: (Int) -> Unit,
    onOrdersClick: () -> Unit
) {
    val stalls = viewModel.stalls.collectAsState()
    var searchQuery by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf(Category.ALL) }

    // Filtered list based on search query and category
    val filteredStalls = stalls.value.filter { stall ->
        val matchesCategory = selectedCategory == Category.ALL || stall.category == selectedCategory
        val matchesSearch = searchQuery.isBlank() || stall.name.contains(searchQuery, ignoreCase = true)
        matchesCategory && matchesSearch
    }

    Scaffold(
        topBar = { TopNavBar(onOrdersClick = onOrdersClick) }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
        ) {

            Spacer(Modifier.height(12.dp))

            // Search bar
            SearchBar(initialQuery = searchQuery) { keyword ->
                searchQuery = keyword
                // Trigger API call here if needed
            }

            Spacer(Modifier.height(8.dp))

            // Category chips
            CategoryChips(selectedCategory = selectedCategory) { category ->
                selectedCategory = category
            }

            Spacer(Modifier.height(8.dp))

            // **Use StallList component here instead of manual LazyColumn**
            StallList(
                stalls = filteredStalls,
                onViewStallClick = { stallId ->
                    onStallClick(stallId)
                }
            )

            if (filteredStalls.isEmpty()) {
                Spacer(Modifier.height(20.dp))
                Text(
                    text = "No stalls found",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
