package com.patriciafiona.subway.model

data class ProductItem(
    val id: Long,
    val image_url: String,
    val title: String,
    val price: Double,
    val category_id: Int,
    val description: String
)
