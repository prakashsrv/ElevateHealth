package com.wellness.elevatehealth.presentation.home

import androidx.lifecycle.ViewModel
import com.wellness.elevatehealth.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dispatchers: DispatcherProvider
) : ViewModel() {
    
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
    
    // Add methods to handle user interactions and update state
}

data class HomeUiState(
    val isLoading: Boolean = false,
    val welcomeMessage: String = "Welcome to Elevate Health",
    val error: String? = null
)