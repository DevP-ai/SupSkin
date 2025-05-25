package com.dev.`in`.supskin.ui.presentation.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.`in`.supskin.R

@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    categoryImage: Int,
    categoryName: String
) {
    Column (
        modifier = Modifier
            .wrapContentSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        Box(
            modifier = Modifier
                .size(90.dp)
                .background(Color.Black, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(categoryImage),
                contentDescription = "Category",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(12.dp)
            )
        }

        Text(
            text = categoryName,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun CategoryItemPreview() {
    Row {
        CategoryItem(
            categoryImage = R.drawable.category_img,
            categoryName = "Cleaner"
        )
        CategoryItem(
            categoryImage = R.drawable.product_img,
            categoryName = "Cleaner"
        )
    }
}