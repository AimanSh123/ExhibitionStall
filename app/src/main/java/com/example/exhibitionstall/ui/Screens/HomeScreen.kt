package com.example.exhibitionstall.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.exhibitionstall.ExhibitionViewModel

@Composable
fun HomeScreen(
    viewModel: ExhibitionViewModel,
    onStallClick: (Int) -> Unit
) {
    val stalls = viewModel.stalls.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Exhibition Stalls", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(20.dp))

        stalls.value.forEach { stall ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onStallClick(stall.id) }
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(stall.name, style = MaterialTheme.typography.titleLarge)
                    Text(stall.category)
                }
            }
        }
    }
}
