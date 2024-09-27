package com.onthecrow.feature1.internal.presentation

import com.onthecrow.core.feature.CoroutineFeature
import com.onthecrow.core.flow.AnyStateFlow
import com.onthecrow.core.flow.wrapToAny
import com.onthecrow.feature1.api.data.Feature1UiState
import com.onthecrow.feature1.internal.data.Feature1Repository
import kotlinx.coroutines.flow.MutableStateFlow

internal class Feature1Feature(
    private val feature1Repository: Feature1Repository,
): CoroutineFeature() {

    private val _state = MutableStateFlow<Feature1UiState>(Feature1UiState.Loading)
    val state: AnyStateFlow<Feature1UiState> = _state.wrapToAny()

    init {
        loadData()
    }

    private fun loadData() {
        _state.value = Feature1UiState.Data(feature1Repository.getData().toUiModel())
    }
}