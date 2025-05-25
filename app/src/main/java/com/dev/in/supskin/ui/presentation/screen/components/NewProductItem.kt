package com.dev.`in`.supskin.ui.presentation.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.`in`.supskin.R
import com.dev.`in`.supskin.ui.domain.model.Product

@Composable
fun NewProductItem(
    modifier: Modifier = Modifier,
    product: Product
) {
    var isFavorite by remember { mutableStateOf(product.isFavorite) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 8.dp, horizontal = 4.dp)
            .background(Color.Transparent)
    ) {
        // Background Image
        Image(
            painter = painterResource(R.drawable.gradient_bg),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )

        // Top Row: Favourite + Best Seller
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .background(Color.Black, shape = CircleShape)
                    .clickable {
                        isFavorite = !isFavorite
                    }
            ) {
                Image(
                    imageVector = if (isFavorite)
                        ImageVector.vectorResource(R.drawable.favourite_filled)
                    else
                        ImageVector.vectorResource(R.drawable.favourite),
                    contentDescription = "Favourite",
                    colorFilter = ColorFilter.tint(Color(0xFFb6a2f0)),
                    modifier = Modifier
                        .padding(8.dp)
                        .size(28.dp)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            if (product.isBestSeller) {
                Surface(
                    color = Color.Black,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier.padding(end = 28.dp)
                ) {
                    Text(
                        text = "Best Seller",
                        modifier = Modifier
                            .padding(horizontal = 12.dp, vertical = 6.dp),
                        color = Color(0xFFb7eb43),
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        // Center Content
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            // Center Product Image
            Image(
                painter = painterResource(product.imageResId),
                contentDescription = "Product Image",
                modifier = Modifier
                    .size(300.dp)
            )

            BottomItem(
                title = product.name,
                inStocked = product.inStocked
            )

        }
    }
}

@Preview
@Composable
fun NewProductItemPreview(modifier: Modifier = Modifier) {
    val sampleProduct = Product(
        id = 1,
        name = "clencera",
        imageResId = R.drawable.product_img,
        isBestSeller = true,
        isFavorite = false,
        inStocked = true
    )

    NewProductItem(product = sampleProduct)
}
