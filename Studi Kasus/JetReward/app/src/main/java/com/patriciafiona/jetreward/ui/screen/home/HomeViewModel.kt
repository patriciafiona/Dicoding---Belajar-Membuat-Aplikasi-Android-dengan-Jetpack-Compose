package com.patriciafiona.jetreward.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patriciafiona.jetreward.ui.common.UiState
import com.patriciafiona.jetreward.data.RewardRepository
import com.patriciafiona.jetreward.model.OrderReward
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch


class HomeViewModel(
    private val repository: RewardRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<OrderReward>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<OrderReward>>>
        get() = _uiState

    fun getAllRewards() {
        viewModelScope.launch {
            repository.getAllRewards()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { orderRewards ->
                    _uiState.value = UiState.Success(orderRewards)
                }
        }
    }
}