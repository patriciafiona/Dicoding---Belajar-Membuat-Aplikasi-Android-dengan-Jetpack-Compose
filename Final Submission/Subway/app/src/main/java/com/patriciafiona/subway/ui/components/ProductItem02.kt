package com.patriciafiona.subway.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.patriciafiona.subway.R
import com.patriciafiona.subway.model.ProductItem
import com.patriciafiona.subway.navigation.SubwayScreen
import com.patriciafiona.subway.ui.theme.VividGreen_100
import com.patriciafiona.subway.utils.Utils.toRupiah

@Composable
fun ProductItem02(navController: NavController, product: ProductItem){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
            .clickable {
                //Go to detail product
                navController.navigate(SubwayScreen.DetailScreen.route)
                navController.currentBackStackEntry?.arguments?.putParcelable("product", product)
            },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Divider()
        Spacer(modifier = Modifier.height(20.dp))
        Row {
           Column(
               modifier = Modifier.weight(1f),
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.Start
           ) {
               Text(
                   product.title,
                   style = TextStyle(
                       fontWeight = FontWeight.Bold,
                       fontSize = 18.sp,
                       color = Color.Black
                   ),
                   maxLines = 1,
                   overflow = TextOverflow.Ellipsis,
               )
               Text(
                   product.description,
                   style = TextStyle(
                       fontSize = 12.sp,
                       color = Color.Black
                   ),
                   maxLines = 2,
                   overflow = TextOverflow.Ellipsis,
               )
               Spacer(modifier = Modifier.height(10.dp))
               Text(
                   toRupiah(product.price),
                   style = TextStyle(
                       fontWeight = FontWeight.Bold,
                       fontSize = 14.sp,
                       color = VividGreen_100
                   ),
               )
           }
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(product.image_url)
                    .crossfade(true)
                    .build(),
                placeholder = painterResource(R.drawable.subway_logo_bg),
                error = painterResource(id = R.drawable.placeholder),
                contentDescription = "Product image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(100.dp)
                    .padding(8.dp)
            )
        }
    }
}