package com.onthecrow.feature5.internal.presentation

import com.onthecrow.feature5.api.data.Feature5UiModel
import com.onthecrow.feature5.internal.domain.model.Feature5DomainModel

internal fun Feature5DomainModel.toUiModel(): Feature5UiModel {
    return Feature5UiModel(title = data)
}