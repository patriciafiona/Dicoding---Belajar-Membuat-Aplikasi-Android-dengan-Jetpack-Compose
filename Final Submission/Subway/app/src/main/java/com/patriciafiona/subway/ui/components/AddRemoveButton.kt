package com.patriciafiona.subway.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.patriciafiona.subway.ui.theme.Marigold_100
import com.patriciafiona.subway.ui.theme.VividGreen_100

@Composable
fun AddRemoveButton(totalOrder: MutableState<Int>, modifier: Modifier = Modifier, isInCart: Boolean = false) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        IconButton(
            onClick = {
                if (isInCart){
                    if (totalOrder.value > 0) {
                        totalOrder.value -= 1
                    }
                }else{
                    if (totalOrder.value > 1) {
                        totalOrder.value -= 1
                    }
                }
            }
        ) {
            Card(
                modifier = Modifier
                    .size(35.dp),
                shape = CircleShape,
                backgroundColor = VividGreen_100
            ) {
                Box(
                    modifier = Modifier.size(15.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Remove,
                        contentDescription = "Remove Icon",
                        tint = Marigold_100,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }

        Text(
            text = totalOrder.value.toString(),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        IconButton(
            onClick = {
                totalOrder.value += 1
            }
        ) {
            Card(
                modifier = Modifier
                    .size(35.dp),
                shape = CircleShape,
                backgroundColor = VividGreen_100
            ) {
                Box(
                    modifier = Modifier.size(15.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Icon",
                        tint = Marigold_100,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
fun AddRemoveButton(
    totalOrder: MutableState<Int>,
    modifier: Modifier = Modifier,
    updateOrder: Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        IconButton(
            onClick = {
                totalOrder.value -= 1
                //Update order directly
                updateOrder
            }
        ) {
            Card(
                modifier = Modifier
                    .size(35.dp),
                shape = CircleShape,
                backgroundColor = VividGreen_100
            ) {
                Box(
                    modifier = Modifier.size(15.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Remove,
                        contentDescription = "Remove Icon",
                        tint = Marigold_100,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }

        Text(
            text = totalOrder.value.toString(),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            ),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        IconButton(
            onClick = {
                totalOrder.value += 1
                //Update order directly
                updateOrder
            }
        ) {
            Card(
                modifier = Modifier
                    .size(35.dp),
                shape = CircleShape,
                backgroundColor = VividGreen_100
            ) {
                Box(
                    modifier = Modifier.size(15.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Icon",
                        tint = Marigold_100,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}