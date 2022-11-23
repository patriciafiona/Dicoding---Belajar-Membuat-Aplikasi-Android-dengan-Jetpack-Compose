package com.patriciafiona.subway.ui.screen.category

import android.widget.HorizontalScrollView
import android.widget.ScrollView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.patriciafiona.subway.di.Injection
import com.patriciafiona.subway.ui.ViewModelFactory
import com.patriciafiona.subway.ui.common.UiState
import com.patriciafiona.subway.ui.components.Carousel
import com.patriciafiona.subway.ui.components.DotsIndicator
import com.patriciafiona.subway.ui.components.Loader
import com.patriciafiona.subway.ui.components.ProductItem02
import com.patriciafiona.subway.ui.screen.home.HomeViewModel
import com.patriciafiona.subway.ui.theme.VividGreen_100

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CategoryScreen(
    navController: NavController,
    selectedCategoryId: Int,
    viewModel: CategoryViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
){
    val selectedCategoryState = remember {
        mutableStateOf(selectedCategoryId)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
         verticalArrangement = Arrangement.Top,
    ){
        CustomTopNavigationBar(navController)

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
                        items(uiState.data){ category ->
                            if(category.id == selectedCategoryState.value){
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
                            }else {
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
                        items(uiState.data){ product ->
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
private fun CustomTopNavigationBar(navController: NavController) {
    IconButton(
        onClick = {
            navController.navigateUp()
        },
         modifier = Modifier.padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back Button")

            Text(
                text = "Category",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f)
            )
        }
    }
}