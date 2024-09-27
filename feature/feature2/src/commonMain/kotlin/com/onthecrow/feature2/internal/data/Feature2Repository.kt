package com.onthecrow.feature2.internal.data

import com.onthecrow.feature2.internal.domain.model.Feature2DomainModel


internal class Feature2Repository {
    fun getData(): Feature2DomainModel = Feature2DomainModel("Feature 2")
}