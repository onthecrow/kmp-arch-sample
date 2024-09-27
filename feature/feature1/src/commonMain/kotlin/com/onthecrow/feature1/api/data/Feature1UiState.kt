package com.onthecrow.feature1.api.data

@Suppress("unused")
sealed class Feature1UiState {

    data object Loading : Feature1UiState()
    data object Error : Feature1UiState()

    data class Data(
        val feature1Data: Feature1UiModel,
    ) : Feature1UiState()
}