package com.onthecrow.feature4.api

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.onthecrow.core.flow.AnyStateFlow
import com.onthecrow.coredi.ComponentKoinContext
import com.onthecrow.feature4.api.data.Feature4UiState
import com.onthecrow.feature4.internal.di.createFeature4Modules
import com.onthecrow.feature4.internal.presentation.Feature4Feature

class Feature4Component(
    componentContext: ComponentContext,
    dependencies: Feature4Dependencies,
) : Feature4, ComponentContext by componentContext {

    private val koinContext = instanceKeeper.getOrCreate {
        ComponentKoinContext()
    }

    private val scope = koinContext.getOrCreateKoinScope(
        createFeature4Modules(dependencies)
    )

    private val feature: Feature4Feature = instanceKeeper.getOrCreate { scope.get() }

    override val state: AnyStateFlow<Feature4UiState> = feature.state
}