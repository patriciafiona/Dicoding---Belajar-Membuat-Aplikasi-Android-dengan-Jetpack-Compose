package com.patriciafiona.subway.ui.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
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
import com.patriciafiona.subway.ui.screen.home.HomeViewModel
import com.patriciafiona.subway.ui.theme.VividGreen_100
import com.patriciafiona.subway.utils.Utils.toRupiah

@Composable
fun ProductItem01(
    navController: NavController,
    product: ProductItem,
    viewModel: HomeViewModel,
    listOfFavorites: ArrayList<Long>
){
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .padding(8.dp)
            .height(220.dp)
            .clickable {
                //Go to detail product
                navController.navigate(SubwayScreen.DetailScreen.route)
                navController.currentBackStackEntry?.arguments?.putParcelable("product", product)
            },
        shape = RoundedCornerShape(5),
        ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box {
                Column {
                    Spacer(modifier = Modifier.height(20.dp))
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
                            .fillMaxWidth()
                            .height(100.dp)
                    )
                }

                IconButton(
                    modifier = Modifier.align(Alignment.TopEnd),
                    onClick = {
                        if(listOfFavorites.contains(product.id)){
                            //remove
                            viewModel.removeFromFavorite(product.id)
                            Toast.makeText(
                                context,
                                "Remove from My Favorites",
                                 Toast.LENGTH_SHORT
                            ).show()
                        }else{
                            //add
                            viewModel.addToFavorite(product.id)
                            Toast.makeText(
                                context,
                                "Add from My Favorites",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                ) {
                    Card(
                        modifier = Modifier
                            .size(35.dp),
                        shape = CircleShape
                    ) {
                        Box(
                            modifier = Modifier.size(15.dp)
                        ) {
                            if (listOfFavorites.contains(product.id)){
                                Icon(
                                    imageVector = Icons.Filled.Favorite,
                                    contentDescription = "Favorite Icon",
                                    tint = Color.Red,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }else{
                                Icon(
                                    imageVector = Icons.Default.FavoriteBorder,
                                    contentDescription = "Unfavorite Icon",
                                    tint = Color.LightGray,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = product.title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                ),
                modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Row(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                 horizontalArrangement = Arrangement.Start
            ){
                Text(
                    text = "35 mins",
                    style = TextStyle(
                        fontWeight = FontWeight.Light,
                        fontSize = 10.sp,
                        color = Color.Black
                    ),
                )
                Icon(
                    imageVector = Icons.Filled.Circle,
                    contentDescription = "Dot icon",
                    modifier = Modifier
                        .size(20.dp)
                        .padding(horizontal = 8.dp)
                )
                Text(
                    text = "7.5 km",
                    style = TextStyle(
                        fontWeight = FontWeight.Light,
                        fontSize = 10.sp,
                        color = Color.Black
                    ),
                )
            }

            Text(
                text = toRupiah(product.price),
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = VividGreen_100
                ),
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                    .weight(1f),
            )
        }
    }
}