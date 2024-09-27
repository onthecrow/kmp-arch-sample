package com.onthecrow.feature4.internal.data

import com.onthecrow.feature4.internal.domain.model.Feature4DomainModel


internal class Feature4Repository {
    fun getData(): Feature4DomainModel = Feature4DomainModel("Feature 4")
}