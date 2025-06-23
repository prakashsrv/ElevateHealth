package com.wellness.elevatehealth.domain.model

data class UiState<T>(
    val isLoading: Boolean = false,
    val data: T? = null,
    val error: String? = null
) {
    val isSuccess: Boolean get() = data != null && !isLoading && error == null
    val isError: Boolean get() = error != null && !isLoading

    companion object {
        fun <T> loading(): UiState<T> = UiState(isLoading = true)
        fun <T> success(data: T): UiState<T> = UiState(data = data)
        fun <T> error(message: String): UiState<T> = UiState(error = message)
    }
}