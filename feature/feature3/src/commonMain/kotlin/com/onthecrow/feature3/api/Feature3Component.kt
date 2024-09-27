package com.onthecrow.feature3.api

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.onthecrow.core.flow.AnyStateFlow
import com.onthecrow.coredi.ComponentKoinContext
import com.onthecrow.feature3.api.data.Feature3UiState
import com.onthecrow.feature3.internal.di.createFeature3Modules
import com.onthecrow.feature3.internal.presentation.Feature3Feature

class Feature3Component(
    componentContext: ComponentContext,
    dependencies: Feature3Dependencies,
) : Feature3, ComponentContext by componentContext {

    private val koinContext = instanceKeeper.getOrCreate {
        ComponentKoinContext()
    }

    private val scope = koinContext.getOrCreateKoinScope(
        createFeature3Modules(dependencies)
    )

    private val feature: Feature3Feature = instanceKeeper.getOrCreate { scope.get() }

    override val state: AnyStateFlow<Feature3UiState> = feature.state
}