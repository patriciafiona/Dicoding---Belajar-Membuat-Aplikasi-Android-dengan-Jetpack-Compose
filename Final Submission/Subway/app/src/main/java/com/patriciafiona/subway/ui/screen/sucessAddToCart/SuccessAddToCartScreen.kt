package com.patriciafiona.subway.ui.screen.sucessAddToCart

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
fun SuccessAddToCart(
    navController: NavController,
    isUpdate: Boolean? = null
){

    LaunchedEffect(Unit) {
        delay(1500L)
        navController.navigate(SubwayScreen.HomeScreen.route)
        navController.currentBackStackEntry?.arguments?.putBoolean("addedNewItem",true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
         verticalArrangement = Arrangement.Center,
         horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.add_to_cart_green))
        Box(modifier = Modifier.size(200.dp)){
            LottieAnimation(
                composition = composition,
                modifier = Modifier
                    .align(Alignment.Center)
                    .fillMaxWidth(),
            )
        }
        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = if(isUpdate == true) { "Success Update Item in the Cart" } else { "Success Add Item to Cart" },
             style = TextStyle(
                 fontSize = 24.sp,
                 color = VividGreen_100,
                 fontWeight = FontWeight.Bold,
                  textAlign = TextAlign.Center
             )
        )
    }
}