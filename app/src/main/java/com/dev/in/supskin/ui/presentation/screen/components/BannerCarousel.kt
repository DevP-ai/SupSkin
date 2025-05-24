package com.dev.`in`.supskin.ui.presentation.screen.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dev.`in`.supskin.R
import com.dev.`in`.supskin.ui.domain.model.BannerData
import kotlinx.coroutines.delay

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BannerCarousel(banners: List<BannerData>) {
    val pagerState = rememberPagerState(initialPage = 0) { banners.size }

    val isScrolling = remember {
        derivedStateOf { pagerState.currentPageOffsetFraction != 0f }
    }

    val indicatorAlpha by animateFloatAsState(
        targetValue = if (isScrolling.value) 0f else 1f,
        animationSpec = tween(durationMillis = 100),
        label = "IndicatorAlpha"
    )

    LaunchedEffect(banners.size) {
        while (true) {
            delay(3500)
            val next = (pagerState.currentPage + 1) % banners.size
            pagerState.animateScrollToPage(
                next,
                animationSpec = tween(durationMillis = 600, easing = FastOutSlowInEasing)
            )
        }
    }

    Box {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) { page ->
            val banner = banners[page]
            BannerItem(
                title = banner.title,
                subtitle = banner.subtitle,
                chipText = banner.chipText,
                image = banner.image
            )
        }

        // Page indicator
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(start = 68.dp)
                .alpha(indicatorAlpha)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                repeat(banners.size) { index ->
                    val color = if (pagerState.currentPage == index)
                        Color(0xFFb7eb43) else Color.Gray.copy(alpha = 0.5f)

                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .width(28.dp)
                            .height(8.dp)
                            .clip(CircleShape)
                            .background(color)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun BannerCarouselPreview(modifier: Modifier = Modifier) {
    val banners = listOf(
        BannerData(title = "GET 20% OFF", subtitle = "On all electronics", chipText = "12-16 October", image = null),
        BannerData(title = "FREE DELIVERY", subtitle = "For orders over ₹1000", chipText = "This Week", image = R.drawable.product_img),
        BannerData(title = "BUY 1 GET 1", subtitle = "On select items", chipText = "Limited Time", image = R.drawable.category_img)
    )

    BannerCarousel(banners = banners)
}
