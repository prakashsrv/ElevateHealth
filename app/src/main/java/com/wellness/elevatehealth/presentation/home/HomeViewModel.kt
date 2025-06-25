package com.wellness.elevatehealth.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wellness.elevatehealth.data.all.model.HomepageResponse
import com.wellness.elevatehealth.domain.repository.HomepageRepository
import com.wellness.elevatehealth.domain.usecase.GetHomepageDataUseCase
import com.wellness.elevatehealth.util.DispatcherProvider
import com.wellness.elevatehealth.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homepageRepository: HomepageRepository,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        loadHomepageData()
    }

    fun loadHomepageData() {
        viewModelScope.launch(dispatchers.main) {
            homepageRepository.getHomepageData().collect { result ->
                _uiState.value = when (result) {
                    is Result.Loading -> {
                        _uiState.value.copy(isLoading = true, error = null)
                    }
                    is Result.Success -> {
                        _uiState.value.copy(
                            isLoading = false,
                            homepageData = result.data,
                            error = null
                        )
                    }
                    is Result.Error -> {
                        _uiState.value.copy(
                            isLoading = false,
                            error = result.exception.message ?: "Unknown error occurred"
                        )
                    }
                }
            }
        }
    }

    fun retryLoading() {
        loadHomepageData()
    }
}

data class HomeUiState(
    val isLoading: Boolean = false,
    val homepageData: HomepageResponse? = null,
    val error: String? = null
) {
    val isSuccess: Boolean get() = homepageData != null && !isLoading && error == null
    val isError: Boolean get() = error != null && !isLoading
}