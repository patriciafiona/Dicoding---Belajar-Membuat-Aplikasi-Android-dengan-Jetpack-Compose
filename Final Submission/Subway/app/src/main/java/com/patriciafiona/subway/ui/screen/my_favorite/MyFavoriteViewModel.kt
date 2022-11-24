package com.patriciafiona.subway.ui.screen.my_favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patriciafiona.subway.data.SubwayRepository
import com.patriciafiona.subway.model.ProductItem
import com.patriciafiona.subway.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MyFavoriteViewModel(
    private val repository: SubwayRepository
): ViewModel() {
    private val _favoriteProductUiState: MutableStateFlow<UiState<List<ProductItem>>> = MutableStateFlow(
        UiState.Loading)
    val favoriteProductUiState: StateFlow<UiState<List<ProductItem>>>
        get() = _favoriteProductUiState

    private val _favoriteUiState: MutableStateFlow<UiState<List<Long>>> = MutableStateFlow(
        UiState.Loading)
    val favoriteUiState: StateFlow<UiState<List<Long>>>
        get() = _favoriteUiState

    fun addToFavorite(productId: Long) {
        viewModelScope.launch {
            repository.addToFavorite(productId)
        }
    }

    fun removeFromFavorite(productId: Long){
        viewModelScope.launch {
            repository.removeFromMyFavorite(productId)
        }
    }

    fun getMyFavorites() {
        viewModelScope.launch {
            repository.getMyFavorite()
                .catch {
                    _favoriteUiState.value = UiState.Error(it.message.toString())
                }
                .collect { items ->
                    _favoriteUiState.value = UiState.Success(items)
                }
        }
    }

    fun getFavoritesProduct() {
        viewModelScope.launch {
            repository.getProductFavorites()
                .catch {
                    _favoriteProductUiState.value = UiState.Error(it.message.toString())
                }
                .collect { items ->
                    _favoriteProductUiState.value = UiState.Success(items)
                }
        }
    }
}