package com.onthecrow.feature4.internal.presentation

import com.onthecrow.core.feature.CoroutineFeature
import com.onthecrow.core.flow.AnyStateFlow
import com.onthecrow.core.flow.wrapToAny
import com.onthecrow.feature4.api.data.Feature4UiState
import com.onthecrow.feature4.internal.data.Feature4Repository
import kotlinx.coroutines.flow.MutableStateFlow

internal class Feature4Feature(
    private val feature4Repository: Feature4Repository,
): CoroutineFeature() {

    private val _state = MutableStateFlow<Feature4UiState>(Feature4UiState.Loading)
    val state: AnyStateFlow<Feature4UiState> = _state.wrapToAny()

    init {
        loadData()
    }

    private fun loadData() {
        _state.value = Feature4UiState.Data(feature4Repository.getData().toUiModel())
    }
}