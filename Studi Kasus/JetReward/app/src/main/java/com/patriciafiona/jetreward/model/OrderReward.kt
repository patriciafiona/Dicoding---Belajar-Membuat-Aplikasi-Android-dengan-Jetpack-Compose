package com.patriciafiona.jetreward.model

import com.patriciafiona.jetreward.model.Reward

data class OrderReward(
    val reward: Reward,
    val count: Int
)