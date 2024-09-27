package com.onthecrow.feature2.api

import com.onthecrow.core.flow.AnyStateFlow
import com.onthecrow.feature2.api.data.Feature2UiState

interface Feature2 {
    val state: AnyStateFlow<Feature2UiState>
}