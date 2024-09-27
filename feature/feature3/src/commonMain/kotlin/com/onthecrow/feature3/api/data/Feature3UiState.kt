package com.onthecrow.feature3.api.data

@Suppress("unused")
sealed class Feature3UiState {

    data object Loading : Feature3UiState()
    data object Error : Feature3UiState()

    data class Data(
        val feature3Data: Feature3UiModel,
    ) : Feature3UiState()
}