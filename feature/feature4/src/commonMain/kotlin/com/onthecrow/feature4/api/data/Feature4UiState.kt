package com.onthecrow.feature4.api.data

@Suppress("unused")
sealed class Feature4UiState {

    data object Loading : Feature4UiState()
    data object Error : Feature4UiState()

    data class Data(
        val feature4Data: Feature4UiModel,
    ) : Feature4UiState()
}