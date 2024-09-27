package com.onthecrow.feature5.internal.presentation

import com.onthecrow.core.feature.CoroutineFeature
import com.onthecrow.core.flow.AnyStateFlow
import com.onthecrow.core.flow.wrapToAny
import com.onthecrow.feature5.api.data.Feature5UiState
import com.onthecrow.feature5.internal.data.Feature5Repository
import kotlinx.coroutines.flow.MutableStateFlow

internal class Feature5Feature(
    private val feature5Repository: Feature5Repository,
): CoroutineFeature() {

    private val _state = MutableStateFlow<Feature5UiState>(Feature5UiState.Loading)
    val state: AnyStateFlow<Feature5UiState> = _state.wrapToAny()

    init {
        loadData()
    }

    private fun loadData() {
        _state.value = Feature5UiState.Data(feature5Repository.getData().toUiModel())
    }
}