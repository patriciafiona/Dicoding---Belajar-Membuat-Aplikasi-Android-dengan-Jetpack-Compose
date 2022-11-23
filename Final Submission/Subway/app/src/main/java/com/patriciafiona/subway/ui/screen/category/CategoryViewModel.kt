package com.patriciafiona.subway.ui.screen.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patriciafiona.subway.data.SubwayRepository
import com.patriciafiona.subway.model.Category
import com.patriciafiona.subway.model.News
import com.patriciafiona.subway.model.ProductItem
import com.patriciafiona.subway.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class CategoryViewModel(
    private val repository: SubwayRepository
) : ViewModel() {
    private val _categoriesUiState: MutableStateFlow<UiState<List<Category>>> = MutableStateFlow(
        UiState.Loading)
    val categoriesUiState: StateFlow<UiState<List<Category>>>
        get() = _categoriesUiState

    private val _productUiState: MutableStateFlow<UiState<List<ProductItem>>> = MutableStateFlow(
        UiState.Loading)
    val productUiState: StateFlow<UiState<List<ProductItem>>>
        get() = _productUiState

    fun getAllCategories() {
        viewModelScope.launch {
            repository.getAllCategories()
                .catch {
                    _categoriesUiState.value = UiState.Error(it.message.toString())
                }
                .collect { items ->
                    _categoriesUiState.value = UiState.Success(items)
                }
        }
    }

    fun getProductByCategoryId(id: Int) {
        viewModelScope.launch {
            repository.getProductByCategoryId(id)
                .catch {
                    _productUiState.value = UiState.Error(it.message.toString())
                }
                .collect { items ->
                    _productUiState.value = UiState.Success(items)
                }
        }
    }
}