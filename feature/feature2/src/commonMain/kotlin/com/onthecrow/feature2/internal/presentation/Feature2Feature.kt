package com.onthecrow.feature2.internal.presentation

import com.onthecrow.core.feature.CoroutineFeature
import com.onthecrow.core.flow.AnyStateFlow
import com.onthecrow.core.flow.wrapToAny
import com.onthecrow.feature2.api.data.Feature2UiState
import com.onthecrow.feature2.internal.data.Feature2Repository
import kotlinx.coroutines.flow.MutableStateFlow

internal class Feature2Feature(
    private val feature2Repository: Feature2Repository,
): CoroutineFeature() {

    private val _state = MutableStateFlow<Feature2UiState>(Feature2UiState.Loading)
    val state: AnyStateFlow<Feature2UiState> = _state.wrapToAny()

    init {
        loadData()
    }

    private fun loadData() {
        _state.value = Feature2UiState.Data(feature2Repository.getData().toUiModel())
    }
}