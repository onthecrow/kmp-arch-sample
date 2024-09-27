package com.onthecrow.feature1.internal.presentation

import com.onthecrow.feature1.api.data.Feature1UiModel
import com.onthecrow.feature1.internal.domain.model.Feature1DomainModel

internal fun Feature1DomainModel.toUiModel(): Feature1UiModel {
    return Feature1UiModel(title = data)
}