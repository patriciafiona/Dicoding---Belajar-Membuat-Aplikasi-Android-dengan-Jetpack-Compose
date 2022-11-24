package com.patriciafiona.subway.ui.screen.favorite_status

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.patriciafiona.subway.R
import com.patriciafiona.subway.navigation.SubwayScreen
import com.patriciafiona.subway.ui.theme.VividGreen_100
import kotlinx.coroutines.delay

@Composable
fun FavoriteStatus(navController: NavController, isAdd: Boolean){
    LaunchedEffect(Unit) {
        delay(1500L)
        navController.navigateUp()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(isAdd) {
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.add_to_favorite))
            Box(modifier = Modifier.size(200.dp)){
                LottieAnimation(
                    composition = composition,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth(),
                )
            }
        }else{
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.remove_from_favorite))
            Box(modifier = Modifier.size(200.dp)){
                LottieAnimation(
                    composition = composition,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .fillMaxWidth(),
                )
            }
        }
        Spacer(modifier = Modifier.height(50.dp))

        val desc = if (isAdd){ "Add to Favorites" } else { "Remove from Favorites" }

        Text(
            text = desc,
            style = TextStyle(
                fontSize = 24.sp,
                color = VividGreen_100,
                fontWeight = FontWeight.Bold
            )
        )
    }
}