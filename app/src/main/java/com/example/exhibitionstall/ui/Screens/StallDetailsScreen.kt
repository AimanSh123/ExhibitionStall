package com.example.exhibitionstall.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.exhibitionstall.ExhibitionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StallDetailsScreen(
    stallId: Int,
    viewModel: ExhibitionViewModel,
    onBack: () -> Unit
) {
    val stall = viewModel.getStallById(stallId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stall?.name ?: "Stall Details") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Text("Back")
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {

            stall?.products?.forEach { product ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(product.name, style = MaterialTheme.typography.titleLarge)
                        Text("₹${product.price}")
                        Button(
                            onClick = { viewModel.addToCart(product) },
                            modifier = Modifier.padding(top = 8.dp)
                        ) {
                            Text("Add to cart")
                        }
                    }
                }
            }
        }
    }
}
