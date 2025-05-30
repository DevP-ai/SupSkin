package com.dev.`in`.supskin.ui.presentation.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.`in`.supskin.R
import com.dev.`in`.supskin.ui.domain.model.BannerData
import com.dev.`in`.supskin.ui.domain.model.Product
import com.dev.`in`.supskin.ui.presentation.screen.components.BannerCarousel
import com.dev.`in`.supskin.ui.presentation.screen.components.CategoryList
import com.dev.`in`.supskin.ui.presentation.screen.components.NewProductItem
import com.dev.`in`.supskin.ui.presentation.screen.components.SecondaryHeader
import com.dev.`in`.supskin.ui.presentation.screen.components.Toolbar

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShopScreen(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 24.dp, horizontal = 2.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        stickyHeader {
            Toolbar()
        }

        item {
            val banners = listOf(
                BannerData(
                    title = "GET 20% OFF",
                    subtitle = "On all electronics",
                    chipText = "12-16 October",
                    image = null
                ),
                BannerData(
                    title = "FREE DELIVERY",
                    subtitle = "For orders over ₹1000",
                    chipText = "This Week",
                    image = R.drawable.product_img
                ),
                BannerData(
                    title = "BUY 1 GET 1",
                    subtitle = "On select items",
                    chipText = "Limited Time",
                    image = R.drawable.category_img
                )
            )

            BannerCarousel(banners = banners)
        }

        item {
            SecondaryHeader(
                leadingText = "Categories",
                trailingText = "See All"
            )
        }

        item {
            val categories = listOf(
                Pair(R.drawable.category_img, "Cleaner"),
                Pair(R.drawable.product_img, "Toner"),
                Pair(R.drawable.product_img, "Toner"),
                Pair(R.drawable.category_img, "Cleaner"),
                Pair(R.drawable.product_img, "Toner"),
                Pair(R.drawable.category_img, "Cleaner"),
                Pair(R.drawable.product_img, "Toner"),
                Pair(R.drawable.category_img, "Cleaner"),
                Pair(R.drawable.product_img, "Toner"),
            )

            CategoryList(categories = categories)
        }

        item {
            SecondaryHeader(
                leadingText = "New Products",
                trailingText = "See All"
            )
        }

        val sampleProduct = listOf<Product>(
            Product(
                id = 1,
                name = "clencera",
                imageResId = R.drawable.product_img,
                isBestSeller = true,
                isFavorite = false,
                inStocked = true
            ),
            Product(
                id = 1,
                name = "glow",
                imageResId = R.drawable.category_img,
                isBestSeller = true,
                isFavorite = false,
                inStocked = false
            ),
            Product(
                id = 1,
                name = "afterglow",
                imageResId = R.drawable.product_img,
                isBestSeller = false,
                isFavorite = false,
                inStocked = true
            )
        )

        items(sampleProduct) { product ->
            NewProductItem(product = product)
        }
    }
}

@Preview
@Composable
fun ShopScreenPreview(modifier: Modifier = Modifier) {
    ShopScreen()
}