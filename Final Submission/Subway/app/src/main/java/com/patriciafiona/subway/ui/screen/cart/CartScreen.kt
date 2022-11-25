package com.patriciafiona.subway.ui.screen.cart

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.LottieComposition
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
import com.patriciafiona.subway.ui.components.ProductItem03
import com.patriciafiona.subway.ui.theme.VividGreen_100
import com.patriciafiona.subway.ui.theme.VividGreen_300
import com.patriciafiona.subway.utils.Utils.toRupiah

@Composable
fun CartScreen(
    navController: NavController,
    viewModel: CartViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    )
) {
    //Screen config
    val configuration = LocalConfiguration.current

    val animComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.empty_cart_green))
    val totalPayment = remember { mutableStateOf(0.0) }

    BackHandler {
        //remove badge by route directly to the Home screen
        navController.navigate(SubwayScreen.HomeScreen.route)
    }

    when (configuration.orientation) {
        Configuration.ORIENTATION_LANDSCAPE -> {
            LandscapeVersion(navController, viewModel, totalPayment, animComposition)
        }
        else -> {
            PortraitVersion(navController, viewModel, totalPayment, animComposition)
        }
    }
}

@Composable
private fun LandscapeVersion(
    navController: NavController,
    viewModel: CartViewModel,
    totalPayment: MutableState<Double>,
    animComposition: LottieComposition?
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopNavigationBar(title = "My Cart", navController = navController, onClickAction = {
            navController.navigate(SubwayScreen.HomeScreen.route)
        })
        
        Row {
            viewModel.productUiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
                when (uiState) {
                    is UiState.Loading -> {
                        viewModel.getProductsInCart()
                        Loader(Modifier.size(80.dp))
                    }
                    is UiState.Success -> {
                        if (uiState.data.isNotEmpty()) {
                            LazyColumn(
                                verticalArrangement = Arrangement.spacedBy(16.dp),
                                contentPadding = PaddingValues(horizontal = 16.dp),
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f)
                                    .padding(vertical = 10.dp)
                                    .testTag("productByCategoryList")
                            ) {
                                items(uiState.data) { order ->
                                    ProductItem03(
                                        navController = navController,
                                        order = order,
                                        viewModel = viewModel
                                    )
                                }
                            }
                        } else {
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .verticalScroll(rememberScrollState()),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Box(modifier = Modifier.fillMaxWidth()) {
                                    LottieAnimation(
                                        composition = animComposition,
                                        modifier = Modifier
                                            .align(Alignment.Center)
                                            .size(100.dp),
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

                                Spacer(modifier = Modifier.height(20.dp))

                                Button(
                                    onClick = {
                                        navController.navigate(SubwayScreen.CategoryScreen.route)
                                        navController.currentBackStackEntry?.arguments?.putInt(
                                            "categoryId",
                                            1
                                        )
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
            
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(16.dp),
                 verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PaymentSummary(viewModel, totalPayment)

                Spacer(modifier = Modifier.weight(1f))
                
                Button(
                    onClick = {
                        // NO IMPLEMENTATION FOR THIS
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp),
                    shape = RoundedCornerShape(50)
                ) {
                    Text(
                        "Place to Order"
                    )
                }
            }
        }
    }
}

@Composable
private fun PortraitVersion(
    navController: NavController,
    viewModel: CartViewModel,
    totalPayment: MutableState<Double>,
    animComposition: LottieComposition?
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopNavigationBar(title = "My Cart", navController = navController, onClickAction = {
            navController.navigate(SubwayScreen.HomeScreen.route)
        })

        viewModel.productUiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
            when (uiState) {
                is UiState.Loading -> {
                    viewModel.getProductsInCart()
                    Loader(Modifier.size(80.dp))
                }
                is UiState.Success -> {
                    if (uiState.data.isNotEmpty()) {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .padding(vertical = 10.dp)
                                .testTag("productByCategoryList")
                        ) {
                            items(uiState.data) { order ->
                                ProductItem03(
                                    navController = navController,
                                    order = order,
                                    viewModel = viewModel
                                )
                            }
                        }

                        PaymentSummary(viewModel, totalPayment)

                        Button(
                            onClick = {
                                // NO IMPLEMENTATION FOR THIS
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, end = 16.dp),
                            shape = RoundedCornerShape(50)
                        ) {
                            Text(
                                "Place to Order"
                            )
                        }
                    } else {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(modifier = Modifier.fillMaxWidth()) {
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
                                    navController.currentBackStackEntry?.arguments?.putInt(
                                        "categoryId",
                                        1
                                    )
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

@Composable
private fun PaymentSummary(
    viewModel: CartViewModel,
    totalPayment: MutableState<Double>
) {
    val deliveryFee = 11000.0
    val serviceAndOtherFee = 8500.0

    totalPayment.value = viewModel.totalPriceInCart.value + deliveryFee + serviceAndOtherFee

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Payment summary",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = VividGreen_300
                )
            )

            PaymentSummaryItem(
                desc = "Price",
                number = viewModel.totalPriceInCart.value
            )

            PaymentSummaryItem(
                desc = "Delivery fee",
                number = deliveryFee
            )

            PaymentSummaryItem(
                desc = "Service and other fee",
                number = serviceAndOtherFee
            )

            Divider(modifier = Modifier.padding(vertical = 10.dp))

            Row {
                Text(
                    text = "Total Payment",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = toRupiah(totalPayment.value),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.Black,
                        textAlign = TextAlign.End
                    ),
                )
            }

        }
    }
}

@Composable
private fun PaymentSummaryItem(desc: String, number: Double) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = desc,
            style = TextStyle(
                color = Color.Gray,
                fontSize = 12.sp
            ),
            modifier = Modifier.weight(1f)
        )

        Text(
            text = toRupiah(number),
            style = TextStyle(
                color = Color.Black,
                fontSize = 12.sp,
                textAlign = TextAlign.End
            ),
        )
    }
}