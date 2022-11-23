package com.patriciafiona.subway.ui.screen.profile

import android.graphics.drawable.Icon
import android.icu.text.CaseMap
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.patriciafiona.subway.ui.components.TitleSubtitle
import com.patriciafiona.subway.ui.components.TopBackBar
import com.patriciafiona.subway.ui.theme.Marigold_300
import com.patriciafiona.subway.ui.theme.VividGreen_100
import com.patriciafiona.subway.ui.theme.VividGreen_500

@Composable
fun ProfileScreen(
    navController: NavController,
    modifier: Modifier
) {
    val isQuickLogin =  remember{
        mutableStateOf(false)
    }
    Scaffold(
        topBar = { TopBackBar(navController = navController, currentPage = "My Profile") }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            UserProfile()

            Divider()

            TitleSubtitle(title = "Account", subtitle = "All information about your account")
            Column(modifier = Modifier.fillMaxWidth()) {
                ProfileRowItem(icon = Icons.Default.List, title = "My Orders", additionalDetail = "See ongoing & history")
                ProfileRowItem(icon = Icons.Default.CreditCard, title = "Payment Methods")
                ProfileRowItem(icon = Icons.Default.HelpCenter, title = "Help center")
                ProfileRowItem(icon = Icons.Default.Language, title = "Change Language")
                ProfileRowItem(icon = Icons.Default.Bookmark, title = "Saved addresses")
                ProfileRowItem(icon = Icons.Default.Group, title = "Invite friends")
                ProfileRowItem(icon = Icons.Default.Fingerprint, title = "Quick login", isQuickLogin = isQuickLogin)
                ProfileRowItem(icon = Icons.Default.AccountCircle, title = "Manage accounts")
                ProfileRowItem(icon = Icons.Default.Security, title = "Account safety")
            }

            TitleSubtitle(title = "General", subtitle = "General settings access")
            Column(modifier = Modifier.fillMaxWidth()) {
                ProfileRowItem(icon = Icons.Default.PrivacyTip, title = "Terms & privacy", additionalDetail = "Accepted", isShowBadge = true)
                ProfileRowItem(icon = Icons.Default.Smartphone, title = "Version", additionalDetail = "v 1.0.0")
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
    isShowBadge: Boolean = false
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
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
                    modifier = Modifier.weight(1f)
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
    ProfileScreen(navController, Modifier)
}