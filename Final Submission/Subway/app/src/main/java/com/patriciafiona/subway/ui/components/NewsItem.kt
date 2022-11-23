package com.patriciafiona.subway.ui.components

import android.R.attr.end
import android.R.attr.maxLines
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.patriciafiona.subway.R
import com.patriciafiona.subway.model.News


@Composable
fun NewsItem(news: News){
    val uriHandler = LocalUriHandler.current

    Card(
        modifier = Modifier.padding(8.dp)
            .clickable {
                uriHandler.openUri(news.news_url)
            },
        shape = RoundedCornerShape(5),

    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(news.image_url)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.subway_logo_bg),
                error = painterResource(id = R.drawable.placeholder),
                contentDescription = "News image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = news.title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                ),
                 modifier = Modifier.padding(8.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
            )

            Text(
                text = news.description,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Light
                ),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(start = 8.dp, bottom = 8.dp, end = 8.dp)
            )
        }
    }
}