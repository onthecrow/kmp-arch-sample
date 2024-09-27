package com.onthecrow.feature5.api

import com.onthecrow.core.flow.AnyStateFlow
import com.onthecrow.feature5.api.data.Feature5UiState

interface Feature5 {
    val state: AnyStateFlow<Feature5UiState>
    fun onDismissClick()
}