package com.patriciafiona.subway.di

import com.patriciafiona.subway.data.SubwayRepository

object Injection {
    fun provideRepository(): SubwayRepository {
        return SubwayRepository.getInstance()
    }
}