package com.patriciafiona.subway.model

import android.content.ClipData
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class OrderItem(
    val item: ProductItem,
    val count: Int
): Parcelable
