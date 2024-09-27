package com.onthecrow.feature4.internal.presentation

import com.onthecrow.feature4.api.data.Feature4UiModel
import com.onthecrow.feature4.internal.domain.model.Feature4DomainModel

internal fun Feature4DomainModel.toUiModel(): Feature4UiModel {
    return Feature4UiModel(title = data)
}