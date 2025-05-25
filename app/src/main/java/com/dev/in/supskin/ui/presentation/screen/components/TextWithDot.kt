package com.dev.`in`.supskin.ui.presentation.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextWithDot(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    textStyle: TextStyle
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(8.dp)
                .background(color, shape = CircleShape)
        )

        Spacer(modifier = Modifier.width(6.dp))

        Text(
            text = text,
            color = color,
            style = textStyle
        )
    }
}

@Preview
@Composable
fun TextWithDotPreview(modifier: Modifier = Modifier) {
    TextWithDot(
        text = "In stock",
        color = Color(0xFFb7eb43),
        textStyle = TextStyle(
            fontWeight = FontWeight.SemiBold
        )
    )
}

