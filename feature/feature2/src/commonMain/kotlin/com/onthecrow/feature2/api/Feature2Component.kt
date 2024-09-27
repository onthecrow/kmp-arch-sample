package com.onthecrow.feature2.api

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.onthecrow.core.flow.AnyStateFlow
import com.onthecrow.coredi.ComponentKoinContext
import com.onthecrow.feature2.api.data.Feature2UiState
import com.onthecrow.feature2.internal.di.createFeature2Modules
import com.onthecrow.feature2.internal.presentation.Feature2Feature

class Feature2Component(
    componentContext: ComponentContext,
    dependencies: Feature2Dependencies,
) : Feature2, ComponentContext by componentContext {

    private val koinContext = instanceKeeper.getOrCreate {
        ComponentKoinContext()
    }

    private val scope = koinContext.getOrCreateKoinScope(
        createFeature2Modules(dependencies)
    )

    private val feature: Feature2Feature = instanceKeeper.getOrCreate { scope.get() }

    override val state: AnyStateFlow<Feature2UiState> = feature.state
}