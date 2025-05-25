package com.dev.`in`.supskin.ui.presentation.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondaryHeader(
    modifier: Modifier = Modifier,
    leadingText: String,
    trailingText: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.Transparent),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = leadingText,
            color = Color.White,
            fontFamily = FontFamily.Serif,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            ),
            modifier = Modifier.weight(1f)
        )
        Text(
            text = trailingText,
            color = Color.White,
            textAlign = TextAlign.Right,
            textDecoration = TextDecoration.Underline
        )
    }
}

@Preview
@Composable
fun SecondaryHeaderPreview(modifier: Modifier = Modifier) {
    SecondaryHeader(
        leadingText = "Categories",
        trailingText = "See All"
    )
}