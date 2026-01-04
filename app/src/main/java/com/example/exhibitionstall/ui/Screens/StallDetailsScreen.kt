package com.example.exhibitionstall.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.exhibitionstall.ExhibitionViewModel
import com.example.exhibitionstall.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StallDetailsScreen(
    stallId: Int,
    viewModel: ExhibitionViewModel,
    onBack: () -> Unit,
    onGoToCart: () -> Unit
) {
    val stall = viewModel.getStallById(stallId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stall?.name ?: "Stall Details")
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = onGoToCart) {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "Go to Cart"
                        )
                    }
                }
            )
        }
    ) { padding ->

        if (stall == null) return@Scaffold

        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(stall.products) { product ->

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Column {

                        // 🔹 Product Image
                        Image(
                            painter = painterResource(id = R.drawable.placeholder_image),
                            contentDescription = product.name,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(160.dp),
                            contentScale = ContentScale.Crop
                        )

                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {

                            // 🔹 Product Name
                            Text(
                                text = product.name,
                                style = MaterialTheme.typography.titleLarge
                            )

                            // 🔹 Category
                            Text(
                                text = product.category,
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.primary
                            )

                            // 🔹 Rating (static)
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = "⭐ 4.5",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }

                            // 🔹 Price
                            Text(
                                text = "₹${product.price}",
                                style = MaterialTheme.typography.titleMedium
                            )

                            // 🔹 Add to Cart
                            Button(
                                onClick = { viewModel.addToCart(product) },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Add to Cart")
                            }
                        }
                    }
                }
            }
        }
    }
}