package com.patriciafiona.subway.navigation

sealed class SubwayScreen(val route: String){
    object HomeScreen: SubwayScreen("home_screen")
    object DetailScreen: SubwayScreen("detail_screen")
    object OrderScreen: SubwayScreen("order_screen")
    object ProfileScreen: SubwayScreen("profile_screen")
    object CategoryScreen: SubwayScreen("category_screen")
}