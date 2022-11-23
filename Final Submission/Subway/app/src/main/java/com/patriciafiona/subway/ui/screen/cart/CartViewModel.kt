package com.patriciafiona.subway.ui.screen.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patriciafiona.subway.data.SubwayRepository
import com.patriciafiona.subway.model.OrderItem
import com.patriciafiona.subway.model.ProductItem
import com.patriciafiona.subway.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class CartViewModel(
    private val repository: SubwayRepository
): ViewModel() {
    private val _productUiState: MutableStateFlow<UiState<List<OrderItem>>> = MutableStateFlow(
        UiState.Loading)
    val productUiState: StateFlow<UiState<List<OrderItem>>>
        get() = _productUiState

    private val _updateUiState: MutableStateFlow<UiState<Boolean>> = MutableStateFlow(
        UiState.Loading)
    val updateUiState: StateFlow<UiState<Boolean>>
        get() = _updateUiState

    private val _removeUiState: MutableStateFlow<UiState<Boolean>> = MutableStateFlow(
        UiState.Loading)
    val removeUiState: StateFlow<UiState<Boolean>>
        get() = _removeUiState


    fun getProductsInCart() {
        viewModelScope.launch {
            repository.getAllProductInCart()
                .catch {
                    _productUiState.value = UiState.Error(it.message.toString())
                }
                .collect { items ->
                    _productUiState.value = UiState.Success(items)
                }
        }
    }

    fun updateProductInCart(productId: Long, total: Int) {
        viewModelScope.launch {
            repository.updateProductInCart(productId = productId, total = total)
                .catch {
                    _updateUiState.value = UiState.Error(it.message.toString())
                }
                .collect { items ->
                    _updateUiState.value = UiState.Success(items)
                }
        }
    }

    fun removeProductInCart(productId: Long){
        viewModelScope.launch {
            repository.removeProductFromCart(productId = productId)
                .catch {
                    _removeUiState.value = UiState.Error(it.message.toString())
                }
                .collect { items ->
                    _removeUiState.value = UiState.Success(items)
                }
        }
    }
}