package com.example.exhibitionstall.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.exhibitionstall.ExhibitionViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrdersScreen(
    viewModel: ExhibitionViewModel,
    onBack: () -> Unit
) {
    val cartItems = viewModel.cart.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My Orders") },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text("Back")
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            if (cartItems.value.isEmpty()) {
                Text(
                    text = "No orders yet",
                    style = MaterialTheme.typography.bodyLarge
                )
            } else {
                cartItems.value.forEach { cartItem ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = cartItem.product.name,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text("Category: ${cartItem.product.category}")
                            Text("Quantity: ${cartItem.quantity}")
                            Text("Price: ₹${cartItem.product.price}")
                        }
                    }
                }
            }
        }
    }
}