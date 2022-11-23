package com.patriciafiona.subway.ui.screen.home

import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.patriciafiona.subway.di.Injection
import com.patriciafiona.subway.ui.ViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import com.patriciafiona.subway.navigation.SubwayScreen
import com.patriciafiona.subway.ui.common.UiState
import com.patriciafiona.subway.ui.components.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(
    navController: NavController, modifier: Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
){
    val carouselState = rememberPagerState()

    Scaffold(
        topBar = {
            TopHomeBar(
                goToCart = {
                    //
                },
                goToDetail = {
                    navController.navigate(SubwayScreen.ProfileScreen.route)
                }
            )
        },
        modifier = Modifier
    ) { innerPadding ->
        Column(
            modifier = modifier
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
                            Carousel(uiState.data, carouselState)
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
            TitleSubtitle(title = "Categories", subtitle = "Get your hands on these tasty foods & drinks")

            viewModel.categoriesUiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
                when (uiState) {
                    is UiState.Loading -> {
                        viewModel.getAllCategories()
                        Loader(modifier.size(80.dp))
                    }
                    is UiState.Success -> {
                        LazyRow(
                            horizontalArrangement = Arrangement.spacedBy(16.dp),
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            modifier = modifier
                                .padding(vertical = 10.dp)
                                .testTag("CategoryList")
                        ) {
                            items(uiState.data) { category ->
                                CategoryItem(category)
                            }
                        }
                    }
                    is UiState.Error -> {}
                }
            }

            TitleSubtitle(title = "Special selections", subtitle = "The best recommendation for our foods/drinks")
            viewModel.selectedProductUiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
                when (uiState) {
                    is UiState.Loading -> {
                        viewModel.getSelectedProduct()
                        Loader(modifier.size(80.dp))
                    }
                    is UiState.Success -> {
                        LazyVerticalGrid(
                            columns = GridCells.Adaptive(170.dp),
                            contentPadding = PaddingValues(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(3.dp),
                            verticalArrangement = Arrangement.spacedBy(3.dp),
                            modifier = modifier
                                .height(500.dp)
                                .testTag("SpecialSelectionList")
                        ) {
                            items(uiState.data) { data ->
                                ProductItem(
                                    product = data
                                )
                            }
                        }
                    }
                    is UiState.Error -> {}
                }
            }

            //News Section
            TitleSubtitle(title = "Subways News", subtitle = "Get all latest news about Subways™ & our products")
            viewModel.newsUiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
                when (uiState) {
                    is UiState.Loading -> {
                        viewModel.getNews()
                        Loader(modifier.size(80.dp))
                    }
                    is UiState.Success -> {
                        LazyColumn(
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            modifier = modifier
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