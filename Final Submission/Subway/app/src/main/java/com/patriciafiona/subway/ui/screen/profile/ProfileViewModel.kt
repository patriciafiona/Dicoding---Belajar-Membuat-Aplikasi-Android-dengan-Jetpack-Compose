package com.patriciafiona.subway.ui.screen.profile

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.patriciafiona.subway.data.SubwayRepository
import com.patriciafiona.subway.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val repository: SubwayRepository
): ViewModel() {
    private val _quickLoginUiState: MutableStateFlow<UiState<MutableState<Boolean>>> = MutableStateFlow(
        UiState.Loading)
    val quickLoginUiState: StateFlow<UiState<MutableState<Boolean>>>
        get() = _quickLoginUiState

    fun getIsQuickLogin() {
        viewModelScope.launch {
            repository.getIsQuickLogin()
                .catch {
                    _quickLoginUiState.value = UiState.Error(it.message.toString())
                }
                .collect { items ->
                    _quickLoginUiState.value = UiState.Success(items)
                }
        }
    }

    fun updateIsQuickLogin(newValue: Boolean) {
        viewModelScope.launch {
            repository.updateIsQuickLogin(newValue)
        }
    }
}