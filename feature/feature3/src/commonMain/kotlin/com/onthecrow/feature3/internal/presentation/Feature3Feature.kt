package com.onthecrow.feature3.internal.presentation

import com.onthecrow.core.feature.CoroutineFeature
import com.onthecrow.core.flow.AnyStateFlow
import com.onthecrow.core.flow.wrapToAny
import com.onthecrow.feature3.api.data.Feature3UiState
import com.onthecrow.feature3.internal.data.Feature3Repository
import kotlinx.coroutines.flow.MutableStateFlow

internal class Feature3Feature(
    private val feature3Repository: Feature3Repository,
): CoroutineFeature() {

    private val _state = MutableStateFlow<Feature3UiState>(Feature3UiState.Loading)
    val state: AnyStateFlow<Feature3UiState> = _state.wrapToAny()

    init {
        loadData()
    }

    private fun loadData() {
        _state.value = Feature3UiState.Data(feature3Repository.getData().toUiModel())
    }
}