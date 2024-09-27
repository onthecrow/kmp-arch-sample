package com.onthecrow.feature5.api

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.onthecrow.core.flow.AnyStateFlow
import com.onthecrow.coredi.ComponentKoinContext
import com.onthecrow.feature5.api.data.Feature5UiState
import com.onthecrow.feature5.internal.presentation.Feature5Feature
import com.onthecrow.feature5.internal.di.createFeature5Modules

class Feature5Component(
    componentContext: ComponentContext,
    dependencies: Feature5Dependencies,
    private val onDismiss: () -> Unit,
) : Feature5, ComponentContext by componentContext {

    private val koinContext = instanceKeeper.getOrCreate {
        ComponentKoinContext()
    }

    private val scope = koinContext.getOrCreateKoinScope(
        createFeature5Modules(dependencies)
    )

    private val feature: Feature5Feature = instanceKeeper.getOrCreate { scope.get() }

    override val state: AnyStateFlow<Feature5UiState> = feature.state

    override fun onDismissClick() {
        onDismiss()
    }
}