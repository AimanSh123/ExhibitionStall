package com.example.exhibitionstall.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.exhibitionstall.R
import com.example.exhibitionstall.model.Category
import com.example.exhibitionstall.model.Product
import com.example.exhibitionstall.model.Stall
import com.example.exhibitionstall.ui.theme.ExhibitionStallTheme

@Composable
fun StallCard(stall: Stall) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.placeholder_image),
                    contentDescription = "Stall Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )

                CategoryBadge(
                    category = stall.category,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                )
            }

            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = stall.name,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    text = stall.description,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

@Composable
fun CategoryBadge(
    category: Category,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.wrapContentSize(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Text(
            text = category.name.replace("_", " "),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSecondary,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StallCardPreview() {
    ExhibitionStallTheme {
        StallCard(
            stall = Stall(
                id = 1,
                name = "Sample Stall",
                description = "This is a sample description for a stall, showcasing various products and services.",
                imageUrl = "placeholder_image",
                category = Category.TECHNOLOGY,
                products = listOf(
                    Product(
                        id = "P1",
                        name = "Sample Product",
                        price = 999.0,
                        category = "Technology"
                    )
                )
            )
        )
    }
}
