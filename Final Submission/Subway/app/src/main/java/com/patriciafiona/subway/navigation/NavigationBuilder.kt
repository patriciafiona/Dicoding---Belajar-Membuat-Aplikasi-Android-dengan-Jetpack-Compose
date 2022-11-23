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
import com.patriciafiona.subway.ui.screen.home.HomeScreen
import com.patriciafiona.subway.ui.screen.profile.ProfileScreen

@Composable
fun NavigationBuilder() {
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = SubwayScreen.HomeScreen.route){
        composable(route = SubwayScreen.HomeScreen.route){
            HomeScreen(navController = navigationController)
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
    }
}