package com.patriciafiona.subway.ui.screen.home

import android.content.res.Configuration
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.patriciafiona.subway.di.Injection
import com.patriciafiona.subway.navigation.SubwayScreen
import com.patriciafiona.subway.ui.ViewModelFactory
import com.patriciafiona.subway.ui.common.UiState
import com.patriciafiona.subway.ui.components.*
import com.patriciafiona.subway.utils.BackPress
import kotlinx.coroutines.delay

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    isAddedNewItem: Boolean? = false
){
    //Screen config
    val configuration = LocalConfiguration.current

    //Back press exit attributes
    var showToast by remember { mutableStateOf(false) }

    var backPressState by remember { mutableStateOf<BackPress>(BackPress.Idle) }
    val context = LocalContext.current

    if(showToast){
        Toast.makeText(context, "Press again to exit", Toast.LENGTH_SHORT).show()
        showToast= false
    }


    LaunchedEffect(key1 = backPressState) {
        if (backPressState == BackPress.InitialTouch) {
            delay(2000)
            backPressState = BackPress.Idle
        }
    }

    BackHandler(backPressState == BackPress.Idle) {
        backPressState = BackPress.InitialTouch
        showToast = true
    }

    //carousel state
    val carouselState = rememberPagerState()

    AppContent(navController, isAddedNewItem, viewModel, configuration, carouselState)
}

@OptIn(ExperimentalPagerApi::class)
@Composable
private fun AppContent(
    navController: NavController,
    isAddedNewItem: Boolean?,
    viewModel: HomeViewModel,
    configuration: Configuration,
    carouselState: PagerState
) {
    Scaffold(
        topBar = {
            TopHomeBar(
                goToCart = {
                    navController.navigate(SubwayScreen.CartScreen.route)
                },
                goToDetail = {
                    navController.navigate(SubwayScreen.ProfileScreen.route)
                },
                isAddedNewItem = isAddedNewItem
            )
        },
        modifier = Modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            //Carousel Section
            viewModel.promotionsUiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
                when (uiState) {
                    is UiState.Loading -> {
                        viewModel.getAllPromotions()
                    }
                    is UiState.Success -> {
                        Box {
                            when (configuration.orientation) {
                                Configuration.ORIENTATION_LANDSCAPE -> {
                                    Carousel(uiState.data, carouselState, width = 550)
                                }
                                else -> {
                                    Carousel(uiState.data, carouselState)
                                }
                            }
                            Box(
                                modifier = Modifier
                                    .align(Alignment.BottomCenter)
                                    .padding(bottom = 15.dp)
                            ) {
                                DotsIndicator(
                                    totalDots = uiState.data.size,
                                    selectedIndex = carouselState.currentPage,
                                )
                            }
                        }
                    }
                    is UiState.Error -> {}
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            //Menu Categories Section
            TitleSubtitle(
                title = "Categories",
                subtitle = "Get your hands on these tasty foods & drinks"
            )

            viewModel.categoriesUiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
                when (uiState) {
                    is UiState.Loading -> {
                        viewModel.getAllCategories()
                        Loader(Modifier.size(80.dp))
                    }
                    is UiState.Success -> {
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            modifier = Modifier
                                .padding(vertical = 10.dp)
                                .testTag("CategoryList")
                        ) {
                            items(uiState.data) { category ->
                                CategoryItem(category, navController)
                            }
                        }
                    }
                    is UiState.Error -> {}
                }
            }

            TitleSubtitle(
                title = "Special selections",
                subtitle = "The best recommendation for our foods/drinks"
            )
            viewModel.favoriteUiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
                when (uiState) {
                    is UiState.Loading -> {
                        viewModel.getMyFavorites()
                    }
                    is UiState.Success -> {
                        val listOfFavorite = uiState.data

                        viewModel.selectedProductUiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
                            when (uiState) {
                                is UiState.Loading -> {
                                    viewModel.getSelectedProduct()
                                    Loader(Modifier.size(80.dp))
                                }
                                is UiState.Success -> {
                                    LazyVerticalGrid(
                                        columns = GridCells.Adaptive(170.dp),
                                        contentPadding = PaddingValues(8.dp),
                                        horizontalArrangement = Arrangement.spacedBy(3.dp),
                                        verticalArrangement = Arrangement.spacedBy(3.dp),
                                        modifier = Modifier
                                            .height(500.dp)
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
                                }
                                is UiState.Error -> {}
                            }
                        }
                    }
                    is UiState.Error -> {}
                }
            }

            //News Section
            TitleSubtitle(
                title = "Subways News",
                subtitle = "Get all latest news about Subways™ & our products"
            )
            viewModel.newsUiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
                when (uiState) {
                    is UiState.Loading -> {
                        viewModel.getNews()
                        Loader(Modifier.size(80.dp))
                    }
                    is UiState.Success -> {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            modifier = Modifier
                                .height(500.dp)
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                                .testTag("CategoryList")
                        ) {
                            items(uiState.data) { news ->
                                NewsItem(news)
                            }
                        }
                    }
                    is UiState.Error -> {}
                }
            }
        }
    }
}