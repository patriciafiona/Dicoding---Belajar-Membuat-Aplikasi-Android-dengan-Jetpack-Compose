package com.patriciafiona.subway.ui.screen.my_favorite

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
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
import com.patriciafiona.subway.ui.components.ProductItem01
import com.patriciafiona.subway.ui.theme.VividGreen_100

@Composable
fun MyFavoriteScreen(
    navController: NavController,
    viewModel: MyFavoriteViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    )
){
    val animComposition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.no_favorite))

    //Screen config
    val configuration = LocalConfiguration.current

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTopNavigationBar(title= "My Cart", navController = navController, onClickAction = {
            navController.navigate(SubwayScreen.HomeScreen.route)
        })

        viewModel.favoriteUiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
            when (uiState) {
                is UiState.Loading -> {
                    viewModel.getMyFavorites()
                }
                is UiState.Success -> {
                    val listOfFavorite = uiState.data

                    viewModel.favoriteProductUiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
                        when (uiState) {
                            is UiState.Loading -> {
                                viewModel.getFavoritesProduct()
                                Loader(Modifier.size(80.dp))
                            }
                            is UiState.Success -> {
                                if(uiState.data.isNotEmpty()) {
                                    LazyVerticalGrid(
                                        columns = GridCells.Adaptive(170.dp),
                                        contentPadding = PaddingValues(8.dp),
                                        horizontalArrangement = Arrangement.spacedBy(3.dp),
                                        verticalArrangement = Arrangement.spacedBy(3.dp),
                                        modifier = Modifier
                                            .weight(1f)
                                            .testTag("SpecialSelectionList")
                                    ) {
                                        items(uiState.data) { data ->
                                            ProductItem01(
                                                product = data,
                                                navController = navController,
                                                viewModel = viewModel,
                                                listOfFavorites = listOfFavorite as ArrayList<Long>
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
                                        when (configuration.orientation) {
                                            Configuration.ORIENTATION_LANDSCAPE -> {
                                                Box(modifier = Modifier.size(100.dp)){
                                                    LottieAnimation(
                                                        composition = animComposition,
                                                        modifier = Modifier
                                                            .align(Alignment.Center)
                                                            .fillMaxWidth(),
                                                        iterations = LottieConstants.IterateForever,
                                                    )
                                                }
                                            }
                                            else -> {
                                                Box(modifier = Modifier.fillMaxWidth()){
                                                    LottieAnimation(
                                                        composition = animComposition,
                                                        modifier = Modifier
                                                            .align(Alignment.Center)
                                                            .fillMaxWidth(),
                                                        iterations = LottieConstants.IterateForever,
                                                    )
                                                }
                                            }
                                        }

                                        Text(
                                            "No Favorites",
                                            style = TextStyle(
                                                fontSize = 24.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = VividGreen_100
                                            )
                                        )
                                    }
                                }
                            }
                            is UiState.Error -> {}
                        }
                    }
                }
                is UiState.Error -> {}
            }
        }
    }
}