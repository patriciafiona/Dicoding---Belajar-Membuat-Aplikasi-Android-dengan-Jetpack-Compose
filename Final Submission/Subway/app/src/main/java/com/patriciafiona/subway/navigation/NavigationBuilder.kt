package com.patriciafiona.subway.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.patriciafiona.subway.ui.screen.DetailScreen
import com.patriciafiona.subway.ui.screen.home.HomeScreen
import com.patriciafiona.subway.ui.screen.profile.ProfileScreen

@Composable
fun NavigationBuilder(
    modifier: Modifier
) {
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = SubwayScreen.HomeScreen.route){
        composable(route = SubwayScreen.HomeScreen.route){
            HomeScreen(navController = navigationController, modifier = modifier)
        }
        composable(route = SubwayScreen.DetailScreen.route){
            DetailScreen(navController = navigationController, modifier = modifier)
        }
        composable(route = SubwayScreen.ProfileScreen.route){
            ProfileScreen(navController = navigationController, modifier = modifier)
        }
    }
}