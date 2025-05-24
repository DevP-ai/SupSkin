package com.dev.`in`.supskin.ui.presentation.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.`in`.supskin.R

@Composable
fun IconWithBadge(
    badge: Int, icon: Int
) {
    Box {
        Icon(
            imageVector = ImageVector.vectorResource(icon),
            contentDescription = "Notification",
            tint = Color(0xFFf3f3f3),
            modifier = Modifier
                .size(28.dp)
                .clickable {

                }
        )
        if (badge > 0) {
            Box(
                modifier = Modifier
                    .offset(x = 1.dp, y = 2.dp)
                    .size(14.dp)
                    .background(Color(0xFFb7eb43), CircleShape)
                    .align(Alignment.BottomEnd),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = badge.toString(),
                    color = Color.Black,
                    fontSize = 10.sp,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}

@Preview
@Composable
fun IconWithBadgePreview(modifier: Modifier = Modifier) {
    Row(Modifier.padding(12.dp)) {
        IconWithBadge(badge = 0, R.drawable.search)
        IconWithBadge(badge = 3, R.drawable.favourite)
        IconWithBadge(badge = 3, R.drawable.cart)
    }
}
