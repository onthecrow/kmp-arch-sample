package com.onthecrow.feature4.api

import com.onthecrow.core.flow.AnyStateFlow
import com.onthecrow.feature4.api.data.Feature4UiState

interface Feature4 {
    val state: AnyStateFlow<Feature4UiState>
}