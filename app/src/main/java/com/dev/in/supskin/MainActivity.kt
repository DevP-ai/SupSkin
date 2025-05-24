package com.dev.`in`.supskin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dev.`in`.supskin.ui.presentation.screen.ShopScreen
import com.dev.`in`.supskin.ui.theme.SupSkinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SupSkinTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize(),
                    containerColor = Color(0xFF2a2a2a)
                ) { innerPadding ->
                    ShopScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
