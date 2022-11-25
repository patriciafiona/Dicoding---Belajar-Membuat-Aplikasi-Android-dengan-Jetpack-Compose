package com.patriciafiona.subway.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.patriciafiona.subway.R
import com.patriciafiona.subway.ui.theme.Marigold_100
import com.patriciafiona.subway.ui.theme.VividGreen_300
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Carousel(
    images: List<Int>,
    carouselState: PagerState,
    width: Int? = null
) {
    LaunchedEffect(key1 = carouselState.currentPage) {
        delay(3000)
        var newPosition = carouselState.currentPage + 1
        if (newPosition > images.size - 1) newPosition = 0
        // scrolling to the new position.
        carouselState.animateScrollToPage(newPosition)
    }


    HorizontalPager(
        state = carouselState,
        count = images.size
    ) { page ->
        if(width != null){
            Column(
                modifier = Modifier
                    .height(300.dp)
                    .width(width.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ImageContainer(images, page)
            }
        }else {
            Column(
                modifier = Modifier
                    .height(260.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ImageContainer(images, page)
            }
        }
    }
}

@Composable
private fun ImageContainer(images: List<Int>, page: Int) {
    Box(contentAlignment = Alignment.BottomCenter) {
        val painter = rememberImagePainter(data = images[page], builder = {
            placeholder(R.drawable.placeholder)
            scale(Scale.FILL)
        })
        Image(
            painter = painter, contentDescription = "", Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(10.dp))
                .fillMaxSize(), contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun DotsIndicator(
    totalDots: Int,
    selectedIndex: Int
) {

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(), horizontalArrangement = Arrangement.Center
    ) {

        items(totalDots) { index ->
            if (index == selectedIndex) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(color = Marigold_100)
                )
            } else {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(color = VividGreen_300)
                )
            }

            if (index != totalDots - 1) {
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}