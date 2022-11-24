package com.patriciafiona.subway.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.patriciafiona.subway.model.ProductItem
import com.patriciafiona.subway.ui.screen.cart.CartScreen
import com.patriciafiona.subway.ui.screen.category.CategoryScreen
import com.patriciafiona.subway.ui.screen.detail.DetailScreen
import com.patriciafiona.subway.ui.screen.favorite_status.FavoriteStatus
import com.patriciafiona.subway.ui.screen.home.HomeScreen
import com.patriciafiona.subway.ui.screen.my_favorite.MyFavoriteScreen
import com.patriciafiona.subway.ui.screen.profile.ProfileScreen
import com.patriciafiona.subway.ui.screen.sucessAddToCart.SuccessAddToCart

@Composable
fun NavigationBuilder() {
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = SubwayScreen.HomeScreen.route){
        composable(route = SubwayScreen.HomeScreen.route){ previousBackStackEntry ->
            val addedNewItem = previousBackStackEntry.arguments?.getBoolean("addedNewItem")
            if (addedNewItem != null){
                HomeScreen(navController = navigationController, isAddedNewItem = addedNewItem)
            }else {
                HomeScreen(navController = navigationController)
            }
        }
        composable(route = SubwayScreen.DetailScreen.route){ previousBackStackEntry ->
            val product = previousBackStackEntry.arguments?.getParcelable<ProductItem>("product")
            if (product != null) {
                DetailScreen(
                    navController = navigationController,
                    product = product
                )
            }
        }
        composable(route = SubwayScreen.ProfileScreen.route){
            ProfileScreen(navController = navigationController)
        }
        composable(route = SubwayScreen.CategoryScreen.route){  previousBackStackEntry ->
            val selectedCategoryId = previousBackStackEntry.arguments?.getInt("categoryId")
            if (selectedCategoryId != null) {
                CategoryScreen(navController = navigationController, selectedCategoryId)
            }
        }
        composable(route = SubwayScreen.CartScreen.route){
            CartScreen(navController = navigationController)
        }
        composable(route = SubwayScreen.SuccessAddToCartScreen.route){
            SuccessAddToCart(navController = navigationController)
        }
        composable(route = SubwayScreen.FavoriteStatusScreen.route){ previousBackStackEntry ->
            val isAdd = previousBackStackEntry.arguments?.getBoolean("isAdd")
            if (isAdd != null) {
                FavoriteStatus(navController = navigationController, isAdd = isAdd)
            }
        }
        composable(route = SubwayScreen.MyFavoriteScreen.route){
            MyFavoriteScreen(navController = navigationController)
        }
    }
}