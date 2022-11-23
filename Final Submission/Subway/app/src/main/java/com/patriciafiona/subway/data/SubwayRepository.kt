package com.patriciafiona.subway.data

import androidx.compose.runtime.mutableStateListOf
import com.patriciafiona.subway.data.source.DataSource
import com.patriciafiona.subway.model.Category
import com.patriciafiona.subway.model.News
import com.patriciafiona.subway.model.OrderItem
import com.patriciafiona.subway.model.ProductItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class SubwayRepository {
    private val specialSelectionById: List<Long> = arrayListOf(
        4, 6, 8, 12, 16, 18, 21, 23, 25, 29, 30
    )
    private val promotions = mutableListOf<Int>()
    private val categories = mutableListOf<Category>()
    private val news = mutableListOf<News>()
    private val specialSelection = mutableListOf<ProductItem>()
    private val productsByCategoryId = mutableStateListOf<ProductItem>()

    init {
        if (promotions.isEmpty()) {
            DataSource.promotions().forEach {
                promotions.add(it)
            }
        }

        if (categories.isEmpty()) {
            DataSource.categories().forEach {
                categories.add(it)
            }
        }

        if (news.isEmpty()) {
            DataSource.news().forEach {
                news.add(it)
            }
        }

        if (specialSelection.isEmpty()) {
            DataSource.products().forEach {
                if(it.id in specialSelectionById){
                    specialSelection.add(it)
                }
            }
        }
    }

    fun getAllPromotions(): Flow<List<Int>> {
        return flowOf(promotions)
    }

    fun getAllCategories(): Flow<List<Category>> {
        return flowOf(categories)
    }

    fun getNews(): Flow<List<News>> {
        return flowOf(news)
    }

    fun getSpecialSelection(): Flow<List<ProductItem>> {
        return flowOf(specialSelection)
    }

    fun getProductByCategoryId(categoryId: Int):  Flow<List<ProductItem>> {
        productsByCategoryId.clear()
        DataSource.products().filter {
            it.category_id == categoryId
        }.forEach { product ->
            productsByCategoryId.add(product)
        }

        return flowOf(productsByCategoryId)
    }

    companion object {
        @Volatile
        private var instance: SubwayRepository? = null

        fun getInstance(): SubwayRepository =
            instance ?: synchronized(this) {
                SubwayRepository().apply {
                    instance = this
                }
            }
    }
}