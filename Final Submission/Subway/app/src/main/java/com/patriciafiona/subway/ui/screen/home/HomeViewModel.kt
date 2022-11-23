package com.patriciafiona.subway.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patriciafiona.subway.ui.common.UiState
import com.patriciafiona.subway.data.SubwayRepository
import com.patriciafiona.subway.model.Category
import com.patriciafiona.subway.model.News
import com.patriciafiona.subway.model.ProductItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: SubwayRepository
) : ViewModel() {
    private val _promotionsUiState: MutableStateFlow<UiState<List<Int>>> = MutableStateFlow(UiState.Loading)
    val promotionsUiState: StateFlow<UiState<List<Int>>>
        get() = _promotionsUiState

    private val _categoriesUiState: MutableStateFlow<UiState<List<Category>>> = MutableStateFlow(
        UiState.Loading)
    val categoriesUiState: StateFlow<UiState<List<Category>>>
        get() = _categoriesUiState

    private val _newsUiState: MutableStateFlow<UiState<List<News>>> = MutableStateFlow(
        UiState.Loading)
    val newsUiState: StateFlow<UiState<List<News>>>
        get() = _newsUiState

    private val _selectedProductUiState: MutableStateFlow<UiState<List<ProductItem>>> = MutableStateFlow(
        UiState.Loading)
    val selectedProductUiState: StateFlow<UiState<List<ProductItem>>>
        get() = _selectedProductUiState

    fun getAllPromotions() {
        viewModelScope.launch {
            repository.getAllPromotions()
                .catch {
                    _promotionsUiState.value = UiState.Error(it.message.toString())
                }
                .collect { items ->
                    _promotionsUiState.value = UiState.Success(items)
                }
        }
    }

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

    fun getNews() {
        viewModelScope.launch {
            repository.getNews()
                .catch {
                    _newsUiState.value = UiState.Error(it.message.toString())
                }
                .collect { items ->
                    _newsUiState.value = UiState.Success(items)
                }
        }
    }

    fun getSelectedProduct() {
        viewModelScope.launch {
            repository.getSpecialSelection()
                .catch {
                    _selectedProductUiState.value = UiState.Error(it.message.toString())
                }
                .collect { items ->
                    _selectedProductUiState.value = UiState.Success(items)
                }
        }
    }
}