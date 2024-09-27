package com.onthecrow.feature5.internal.data

import com.onthecrow.feature5.internal.domain.model.Feature5DomainModel

internal class Feature5Repository {
    fun getData(): Feature5DomainModel = Feature5DomainModel("Feature 5")
}