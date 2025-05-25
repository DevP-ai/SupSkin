package com.dev.`in`.supskin.ui.domain.model

data class Product(
    val id: Int,
    val name: String,
    val imageResId: Int,
    val isBestSeller: Boolean,
    val isFavorite: Boolean,
    val inStocked: Boolean
)