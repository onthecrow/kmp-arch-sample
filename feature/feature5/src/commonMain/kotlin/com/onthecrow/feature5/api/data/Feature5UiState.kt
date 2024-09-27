package com.onthecrow.feature5.api.data

@Suppress("unused")
sealed class Feature5UiState {

    data object Loading : Feature5UiState()
    data object Error : Feature5UiState()

    data class Data(
        val feature5Data: Feature5UiModel,
    ) : Feature5UiState()
}