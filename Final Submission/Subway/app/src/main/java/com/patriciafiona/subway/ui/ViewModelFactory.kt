package com.patriciafiona.subway.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.patriciafiona.subway.data.SubwayRepository
import com.patriciafiona.subway.ui.screen.category.CategoryViewModel
import com.patriciafiona.subway.ui.screen.home.HomeViewModel

class ViewModelFactory(private val repository: SubwayRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(CategoryViewModel::class.java)) {
            return CategoryViewModel(repository) as T
        }
//        } else if (modelClass.isAssignableFrom(CartViewModel::class.java)) {
//            return CartViewModel(repository) as T
//        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}