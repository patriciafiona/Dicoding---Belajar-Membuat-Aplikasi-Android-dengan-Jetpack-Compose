package com.patriciafiona.subway.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.patriciafiona.subway.model.Category
import com.patriciafiona.subway.ui.theme.FloralWhite
import com.patriciafiona.subway.ui.theme.VividGreen_500

@Composable
fun CategoryItem(
    category: Category
){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box {
            Card(
                modifier = Modifier
                    .size(65.dp),
                shape = CircleShape,
                backgroundColor = FloralWhite,
                content = {}
            )

            Image(
                painter = painterResource(id = category.image),
                contentDescription = "Image in Category Item",
                modifier = Modifier
                    .size(55.dp)
                    .align(Alignment.Center)
            )
        }
        Box(modifier = Modifier.height(8.dp))
        Text(
            text = category.name,
            style = TextStyle(
                fontSize = 12.sp,
                color = VividGreen_500,
                fontWeight = FontWeight.Bold
            )
        )
    }
}