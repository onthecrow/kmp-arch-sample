package com.onthecrow.feature2.api.data

@Suppress("unused")
sealed class Feature2UiState {

    data object Loading : Feature2UiState()
    data object Error : Feature2UiState()

    data class Data(
        val feature2Data: Feature2UiModel,
    ) : Feature2UiState()
}