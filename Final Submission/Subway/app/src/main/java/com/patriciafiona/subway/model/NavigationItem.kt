package com.patriciafiona.subway.model

import androidx.compose.ui.graphics.vector.ImageVector
import com.patriciafiona.subway.navigation.SubwayScreen

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val screen: SubwayScreen
)
