package com.patriciafiona.jetreward.ui.screen.cart

import com.patriciafiona.jetreward.model.OrderReward


data class CartState(
    val orderReward: List<OrderReward>,
    val totalRequiredPoint: Int
)