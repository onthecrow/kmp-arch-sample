package com.onthecrow.feature3.internal.presentation

import com.onthecrow.feature3.api.data.Feature3UiModel
import com.onthecrow.feature3.internal.domain.model.Feature3DomainModel

internal fun Feature3DomainModel.toUiModel(): Feature3UiModel {
    return Feature3UiModel(title = data)
}