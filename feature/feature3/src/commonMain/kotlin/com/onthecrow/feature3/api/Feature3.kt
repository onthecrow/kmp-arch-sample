package com.onthecrow.feature3.api

import com.onthecrow.core.flow.AnyStateFlow
import com.onthecrow.feature3.api.data.Feature3UiState

interface Feature3 {
    val state: AnyStateFlow<Feature3UiState>
}