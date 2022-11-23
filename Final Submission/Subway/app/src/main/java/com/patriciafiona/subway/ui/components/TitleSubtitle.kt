package com.patriciafiona.subway.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.patriciafiona.subway.ui.theme.VividGreen_100

@Composable
fun TitleSubtitle(
    title: String, subtitle: String
){
    Column(modifier = Modifier.padding(vertical = 10.dp)) {
        Title(title)
        Subtitle(subtitle)
    }
}

@Composable
private fun Subtitle(subtitle: String) {
    Text(
        text = subtitle,
        style = TextStyle(
            fontSize = 12.sp,
            color = Color.Gray
        ),
        modifier = Modifier
            .padding(start = 20.dp)
    )
}

@Composable
fun Title(title: String, modifier: Modifier = Modifier.padding(start = 20.dp)) {
    Text(
        text = title,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = VividGreen_100
        ),
        modifier = modifier

    )
}