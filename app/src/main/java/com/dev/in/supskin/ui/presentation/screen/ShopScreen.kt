package com.dev.`in`.supskin.ui.presentation.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    }
}

@Preview
@Composable
fun ShopScreenPreview(modifier: Modifier = Modifier) {
    ShopScreen()
}