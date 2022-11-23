package com.patriciafiona.subway.ui.screen.cart

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.patriciafiona.subway.R
import com.patriciafiona.subway.di.Injection
import com.patriciafiona.subway.navigation.SubwayScreen
import com.patriciafiona.subway.ui.ViewModelFactory
import com.patriciafiona.subway.ui.common.UiState
import com.patriciafiona.subway.ui.components.CustomTopNavigationBar
import com.patriciafiona.subway.ui.components.Loader
import com.patriciafiona.subway.ui.components.ProductItem02
import com.patriciafiona.subway.ui.screen.category.CategoryViewModel
import com.patriciafiona.subway.ui.theme.VividGreen_100

@Composable
fun CartScreen(
    navController: NavController,
    viewModel: CartViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    )
) {
    val animComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.empty_cart_green))

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopNavigationBar(title= "My Cart", navController = navController)

        viewModel.productUiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
            when (uiState) {
                is UiState.Loading -> {
                    viewModel.getProductsInCart()
                    Loader(Modifier.size(80.dp))
                }
                is UiState.Success -> {
                    if(uiState.data.isNotEmpty()){
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                                .testTag("productByCategoryList")
                        ) {
                            items(uiState.data){ order ->
                                ProductItem02(
                                    navController = navController,
                                    product = order.item
                                )
                            }
                        }
                    }else{
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(modifier = Modifier.fillMaxWidth()){
                                LottieAnimation(
                                    composition = animComposition,
                                    modifier = Modifier
                                        .align(Alignment.Center)
                                        .fillMaxWidth(),
                                    iterations = LottieConstants.IterateForever,
                                )
                            }

                            Text(
                                "Your cart still empty",
                                 style = TextStyle(
                                     fontSize = 24.sp,
                                     fontWeight = FontWeight.Bold,
                                     color = VividGreen_100
                                 )
                            )

                            Spacer(modifier = Modifier.fillMaxHeight(.3f))

                            Button(
                                onClick = {
                                    navController.navigate(SubwayScreen.CategoryScreen.route)
                                    navController.currentBackStackEntry?.arguments?.putInt("categoryId", 1)
                                },
                                shape = RoundedCornerShape(50)
                            ) {
                                Text(text = "Browse our foods & drinks")
                            }
                        }
                    }
                }
                is UiState.Error -> {}
            }
        }
    }
}