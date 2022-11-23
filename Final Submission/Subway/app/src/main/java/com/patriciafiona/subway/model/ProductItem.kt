package com.patriciafiona.subway.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductItem(
    val id: Long,
    val image_url: String,
    val title: String,
    val price: Double,
    val category_id: Int,
    val description: String,
    val web_url: String
) : Parcelable
