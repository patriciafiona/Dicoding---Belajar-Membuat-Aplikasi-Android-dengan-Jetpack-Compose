package com.patriciafiona.subway.ui.screen.category

import android.content.res.Configuration
import android.util.Log
import android.widget.ScrollView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.flowlayout.FlowRow
import com.patriciafiona.subway.di.Injection
import com.patriciafiona.subway.ui.ViewModelFactory
import com.patriciafiona.subway.ui.common.UiState
import com.patriciafiona.subway.ui.components.*
import com.patriciafiona.subway.ui.theme.VividGreen_100

@Composable
fun CategoryScreen(
    navController: NavController,
    selectedCategoryId: Int,
    viewModel: CategoryViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    )
){
    val selectedCategoryState = remember {
        mutableStateOf(selectedCategoryId)
    }

    //Screen config
    val configuration = LocalConfiguration.current

    Column(
        modifier = Modifier
            .fillMaxWidth(),
         verticalArrangement = Arrangement.Top,
    ){
        CustomTopNavigationBar(title= "Category", navController = navController)

        when (configuration.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> {
                LandscapeVersion(viewModel, selectedCategoryState, navController)
            }
            else -> {
                PortraitVersion(viewModel, selectedCategoryState, navController)
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
private fun LandscapeVersion(
    viewModel: CategoryViewModel,
    selectedCategoryState: MutableState<Int>,
    navController: NavController
) {

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        //Chips
        viewModel.categoriesUiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
            when (uiState) {
                is UiState.Loading -> {
                    viewModel.getAllCategories()
                }
                is UiState.Success -> {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .verticalScroll(rememberScrollState())
                    ) {
                        FlowRow(
                            modifier = Modifier
                                .padding(start = 16.dp)
                                .testTag("CategoryChipList"),
                            mainAxisSpacing = 8.dp,
                            crossAxisSpacing = 8.dp,
                        ) {
                            (uiState.data).forEach { category ->
                                if (category.id == selectedCategoryState.value) {
                                    Chip(
                                        onClick = {
                                            viewModel.getProductByCategoryId(category.id)
                                            selectedCategoryState.value = category.id
                                            Log.e("CLICKED", "CHIP CLICKED: ${category.name}")
                                        },
                                        border = BorderStroke(
                                            ChipDefaults.OutlinedBorderSize,
                                            VividGreen_100
                                        ),
                                        colors = ChipDefaults.chipColors(
                                            backgroundColor = Color.White,
                                            contentColor = VividGreen_100
                                        )
                                    ) {
                                        Text(category.name)
                                    }
                                } else {
                                    Chip(
                                        onClick = {
                                            viewModel.getProductByCategoryId(category.id)
                                            selectedCategoryState.value = category.id
                                            Log.e("CLICKED", "CHIP CLICKED: ${category.name}")
                                        },
                                        colors = ChipDefaults.chipColors(
                                            backgroundColor = VividGreen_100,
                                            contentColor = Color.White
                                        )
                                    ) {
                                        Text(category.name)
                                    }
                                }
                            }
                        }
                    }
                }
                is UiState.Error -> {}
            }
        }

        //Products
        viewModel.productUiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
            when (uiState) {
                is UiState.Loading -> {
                    viewModel.getProductByCategoryId(selectedCategoryState.value)
                    Loader(Modifier.size(80.dp))
                }
                is UiState.Success -> {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        modifier = Modifier
                            .weight(3f)
                            .padding(vertical = 10.dp)
                            .testTag("productByCategoryList")
                    ) {
                        items(uiState.data, key = { product -> product.id }) { product ->
                            ProductItem02(
                                navController = navController,
                                product = product
                            )
                        }
                    }
                }
                is UiState.Error -> {}
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
private fun PortraitVersion(
    viewModel: CategoryViewModel,
    selectedCategoryState: MutableState<Int>,
    navController: NavController
) {
    Column {
        //Chips
        viewModel.categoriesUiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
            when (uiState) {
                is UiState.Loading -> {
                    viewModel.getAllCategories()
                }
                is UiState.Success -> {
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        contentPadding = PaddingValues(horizontal = 8.dp),
                        modifier = Modifier
                            .padding(start = 16.dp)
                            .testTag("CategoryChipList")
                    ) {
                        items(uiState.data) { category ->
                            if (category.id == selectedCategoryState.value) {
                                Chip(
                                    onClick = {
                                        viewModel.getProductByCategoryId(category.id)
                                        selectedCategoryState.value = category.id
                                    },
                                    border = BorderStroke(
                                        ChipDefaults.OutlinedBorderSize,
                                        VividGreen_100
                                    ),
                                    colors = ChipDefaults.chipColors(
                                        backgroundColor = Color.White,
                                        contentColor = VividGreen_100
                                    )
                                ) {
                                    Text(category.name)
                                }
                            } else {
                                Chip(
                                    onClick = {
                                        viewModel.getProductByCategoryId(category.id)
                                        selectedCategoryState.value = category.id
                                    },
                                    colors = ChipDefaults.chipColors(
                                        backgroundColor = VividGreen_100,
                                        contentColor = Color.White
                                    )
                                ) {
                                    Text(category.name)
                                }
                            }
                        }
                    }
                }
                is UiState.Error -> {}
            }
        }

        //Products
        viewModel.productUiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
            when (uiState) {
                is UiState.Loading -> {
                    viewModel.getProductByCategoryId(selectedCategoryState.value)
                    Loader(Modifier.size(80.dp))
                }
                is UiState.Success -> {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp)
                            .testTag("productByCategoryList")
                    ) {
                        items(uiState.data, key = { product -> product.id }) { product ->
                            ProductItem02(
                                navController = navController,
                                product = product
                            )
                        }
                    }
                }
                is UiState.Error -> {}
            }
        }
    }
}