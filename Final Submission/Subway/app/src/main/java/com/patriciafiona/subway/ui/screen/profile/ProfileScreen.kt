package com.patriciafiona.subway.ui.screen.profile

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.patriciafiona.subway.R
import com.patriciafiona.subway.di.Injection
import com.patriciafiona.subway.navigation.SubwayScreen
import com.patriciafiona.subway.ui.ViewModelFactory
import com.patriciafiona.subway.ui.common.UiState
import com.patriciafiona.subway.ui.components.TitleSubtitle
import com.patriciafiona.subway.ui.components.TopBackBar
import com.patriciafiona.subway.ui.theme.VividGreen_100
import com.patriciafiona.subway.ui.theme.VividGreen_500

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
) {
    val isQuickLogin =  remember{
        mutableStateOf(false)
    }

    //update isQuickLogin from repository
    viewModel.quickLoginUiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getIsQuickLogin()
            }
            is UiState.Success -> {
                isQuickLogin.value = uiState.data.value
            }
            is UiState.Error -> {}
        }
    }

    Scaffold(
        topBar = { TopBackBar(navController = navController, currentPage = "My Profile") }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            UserProfile()

            Divider()

            TitleSubtitle(title = "Account", subtitle = "All information about your account")
            Column(modifier = Modifier.fillMaxWidth()) {
                ProfileRowItem(icon = Icons.Default.List, title = "My Orders", additionalDetail = "See ongoing & history", navController = navController)
                ProfileRowItem(
                    icon = Icons.Default.Favorite,
                    title = "My Favorites",
                    additionalDetail = "See likes history",
                    navigateRoute = SubwayScreen.MyFavoriteScreen.route,
                    navController = navController
                )
                ProfileRowItem(icon = Icons.Default.CreditCard, title = "Payment Methods", navController = navController)
                ProfileRowItem(icon = Icons.Default.HelpCenter, title = "Help center", navController = navController)
                ProfileRowItem(icon = Icons.Default.Language, title = "Change Language", navController = navController)
                ProfileRowItem(icon = Icons.Default.Bookmark, title = "Saved addresses", navController = navController)
                ProfileRowItem(icon = Icons.Default.Group, title = "Invite friends", navController = navController)
                ProfileRowItem(icon = Icons.Default.Fingerprint, title = "Quick login", isQuickLogin = isQuickLogin, viewModel = viewModel, navController = navController)
                ProfileRowItem(icon = Icons.Default.AccountCircle, title = "Manage accounts", navController = navController)
                ProfileRowItem(icon = Icons.Default.Security, title = "Account safety", navController = navController)
            }

            TitleSubtitle(title = "General", subtitle = "General settings access")
            Column(modifier = Modifier.fillMaxWidth()) {
                ProfileRowItem(icon = Icons.Default.PrivacyTip, title = "Terms & privacy", additionalDetail = "Accepted", isShowBadge = true, navController = navController)
                ProfileRowItem(icon = Icons.Default.Smartphone, title = "Version", additionalDetail = "v 1.0.0", navController = navController)
            }
        }
    }

}

@Composable
fun ProfileRowItem(
    icon: ImageVector,
    title: String,
    additionalDetail: String? = null,
    isQuickLogin: MutableState<Boolean>? = null,
    isShowBadge: Boolean = false,
    viewModel: ProfileViewModel? = null,
    navigateRoute: String? = null,
     navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .clickable {
                if (!navigateRoute.isNullOrEmpty()) {
                    navController.navigate(navigateRoute)
                }
            },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            if(!isShowBadge){
                Icon(
                    imageVector = icon,
                    contentDescription = "Icon",
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end = 8.dp)
                )
            }else{
                BadgedBox(
                    modifier = Modifier
                        .padding(end = 16.dp),
                    badge = {
                        Badge{}
                    }
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Icon",
                    )
                }
            }

            Text(
                title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp
                ),
                modifier = Modifier.weight(1f)
            )
            if(additionalDetail != null){
                Text(
                    additionalDetail,
                    style = TextStyle(
                        fontSize = 12.sp,
                        textAlign = TextAlign.End
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 3.dp)
                )
            }

            if(isQuickLogin == null) {
                Icon(
                    imageVector = Icons.Default.ArrowForwardIos,
                    contentDescription = "Icon Next",
                    modifier = Modifier
                        .size(15.dp)
                )
            }else{
                Switch(
                    checked = isQuickLogin.value,
                    onCheckedChange = {
                        isQuickLogin.value = !isQuickLogin.value
                        viewModel?.updateIsQuickLogin(isQuickLogin.value)
                    }
                )
            }
        }

        Divider(modifier = Modifier.padding(top = 8.dp))
    }
}

@Composable
private fun UserProfile() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        Image(
            painter = painterResource(id = R.drawable.patriciafiona),
            contentDescription = "User Photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(16.dp)
                .size(80.dp)
                .clip(CircleShape)                       // clip to the circle shape
                .border(3.dp, VividGreen_500, CircleShape)
        )
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = "Patricia Fiona",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = VividGreen_100
                )
            )

            Text(
                text = "patriciafiona3@gmail.com",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.Black
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview(){
    val navController = rememberNavController()
    ProfileScreen(navController)
}