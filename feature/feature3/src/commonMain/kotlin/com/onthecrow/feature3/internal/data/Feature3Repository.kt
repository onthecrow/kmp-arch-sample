package com.onthecrow.feature3.internal.data

import com.onthecrow.feature3.internal.domain.model.Feature3DomainModel


internal class Feature3Repository {
    fun getData(): Feature3DomainModel = Feature3DomainModel("Feature 3")
}