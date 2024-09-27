package com.onthecrow.feature2.internal.presentation

import com.onthecrow.feature2.api.data.Feature2UiModel
import com.onthecrow.feature2.internal.domain.model.Feature2DomainModel

internal fun Feature2DomainModel.toUiModel(): Feature2UiModel {
    return Feature2UiModel(title = data)
}