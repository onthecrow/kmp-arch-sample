package com.onthecrow.feature1.internal.data

import com.onthecrow.feature1.internal.domain.model.Feature1DomainModel


internal class Feature1Repository {
    fun getData(): Feature1DomainModel = Feature1DomainModel("Feature 1")
}