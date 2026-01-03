package com.example.exhibitionstall.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exhibitionstall.R
import com.example.exhibitionstall.ui.theme.ExhibitionStallTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavBar(
    onOrdersClick: () -> Unit = {}
) {
    Column {
        TopAppBar(
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_stall_icon),
                        contentDescription = "Stall Icon",
                        modifier = Modifier
                            .size(28.dp)
                            .padding(end = 8.dp)
                    )

                    // Title
                    Text(
                        text = "Exhibition Stall",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
            },
            actions = {
                // Orders button on right
                IconButton(onClick = onOrdersClick) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_orders),
                        contentDescription = "Orders",
                        modifier = Modifier.size(26.dp)
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        )

        // Bottom separator line
        Divider(
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopNavBarPreview() {
    ExhibitionStallTheme {
        TopNavBar()
    }
}
