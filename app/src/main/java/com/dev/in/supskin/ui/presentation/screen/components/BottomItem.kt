package com.dev.`in`.supskin.ui.presentation.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dev.`in`.supskin.R
import com.dev.`in`.supskin.ui.theme.vulcantFontFamily

@Composable
fun BottomItem(
    modifier: Modifier = Modifier,
    title: String,
    inStocked: Boolean
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Background Image (Card Shape)
        Image(
            painter = painterResource(R.drawable.card_black_shape),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 8.dp, end = 20.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    color = Color(0xFFb7eb43),
                    fontSize = 32.sp,
                    fontFamily = vulcantFontFamily
                )

                if(inStocked){
                    TextWithDot(
                        text = "In stock",
                        color = Color(0xFFb7eb43),
                        textStyle = TextStyle(
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }else{
                    TextWithDot(
                        text = "Out of stock",
                        color = Color.Red,
                        textStyle = TextStyle(
                            fontWeight = FontWeight.SemiBold
                        )
                    )
                }

            }

            Text(
                text = "French clay and algae-powered cleanser",
                color = Color.White
            )

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Text(
                    text = "Skin Tightness",
                    color = Color.White,
                    style = TextStyle(
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold
                    )
                )
                TextWithDot(
                    text = "Dry & Dehyrated Skin",
                    color = Color.White,
                    textStyle = TextStyle(
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.SemiBold
                    )
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ){
                Text(
                    text = "RS. 355.20",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "RS. 444.0",
                    color = Color.Gray,
                    textDecoration = TextDecoration.LineThrough
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                StarItem()
                Text(
                    text = "249 reviews",
                    color = Color.White,
                    textDecoration = TextDecoration.Underline,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

        }



        // Favourite Icon at BottomEnd
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(8.dp)
                .border(1.dp,Color(0xFFb7eb43), shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.cart_filled),
                contentDescription = "Favourite Bottom",
                modifier = Modifier
                    .padding(8.dp)
                    .size(28.dp)
            )
        }
    }
}

@Preview
@Composable
fun BottomItemPreview(modifier: Modifier = Modifier) {
    BottomItem(title = "glow", inStocked = true)
}
