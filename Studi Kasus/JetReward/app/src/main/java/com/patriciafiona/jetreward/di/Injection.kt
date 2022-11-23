package com.patriciafiona.jetreward.di

import com.patriciafiona.jetreward.data.RewardRepository

object Injection {
    fun provideRepository(): RewardRepository {
        return RewardRepository.getInstance()
    }
}