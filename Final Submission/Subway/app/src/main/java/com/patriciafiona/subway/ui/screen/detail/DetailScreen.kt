package com.patriciafiona.subway.ui.screen.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.patriciafiona.subway.R
import com.patriciafiona.subway.di.Injection
import com.patriciafiona.subway.model.ProductItem
import com.patriciafiona.subway.navigation.SubwayScreen
import com.patriciafiona.subway.ui.ViewModelFactory
import com.patriciafiona.subway.ui.components.AddRemoveButton
import com.patriciafiona.subway.ui.components.Title
import com.patriciafiona.subway.ui.screen.cart.CartViewModel
import com.patriciafiona.subway.ui.theme.Marigold_100
import com.patriciafiona.subway.ui.theme.VividGreen_100
import com.patriciafiona.subway.ui.theme.VividGreen_300
import com.patriciafiona.subway.ui.theme.VividGreen_500
import com.patriciafiona.subway.utils.Utils.toRupiah

@Composable
fun DetailScreen(
    navController: NavController,
    product: ProductItem,
    viewModel: DetailViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    )
) {

    val totalOrder = remember{ mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        CustomTopNavigationBar(navController)

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            TopSection(product)
            DescriptionSection(product)
            WebsiteSection(product.web_url)
            AddRemoveButton(
                totalOrder,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
            )
        }

        Button(
            onClick = {
                  //add to cart
                  viewModel.addProductToCart(
                      product = product,
                      total = totalOrder.value
                  )
                //go to success screen
                navController.navigate(SubwayScreen.SuccessAddToCartScreen.route)
            },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(50)
        ) {
            Text(
                "Add to Order"
            )
        }
    }
}

@Composable
fun WebsiteSection(webUrl: String) {
    val uriHandler = LocalUriHandler.current

    Title(title = "Website", modifier = Modifier.padding(top = 16.dp))

    Text(
        webUrl,
        style = TextStyle(
            fontSize = 14.sp,
            textDecoration = TextDecoration.Underline,
            color = VividGreen_300
        ),
         modifier = Modifier.clickable {
             uriHandler.openUri(webUrl)
         },
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
private fun CustomTopNavigationBar(navController: NavController) {
    IconButton(onClick = {
        navController.navigateUp()
    }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back Button")

            Text(
                text = "Detail Product",
                style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f)
            )

            IconButton(
                onClick = {}
            ) {
                Card(
                    modifier = Modifier
                        .size(35.dp),
                    shape = CircleShape
                ) {
                    Box(
                        modifier = Modifier.size(15.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite Icon",
                            tint = Color.LightGray,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TopSection(product: ProductItem) {
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
            .height(300.dp)
    )

    Text(
        product.title,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 28.sp
        )
    )

    Text(
        toRupiah(product.price),
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            color = VividGreen_100,
            fontSize = 20.sp
        )
    )
}

@Composable
private fun DescriptionSection(product: ProductItem) {
    Title(title = "Description", modifier = Modifier.padding(top = 16.dp))

    Text(
        product.description,
        style = TextStyle(
            color = Color.Black,
            fontSize = 14.sp
        )
    )
}