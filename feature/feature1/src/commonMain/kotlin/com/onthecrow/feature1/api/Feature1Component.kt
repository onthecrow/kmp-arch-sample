package com.onthecrow.feature1.api

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.onthecrow.core.flow.AnyStateFlow
import com.onthecrow.coredi.ComponentKoinContext
import com.onthecrow.feature1.api.data.Feature1UiState
import com.onthecrow.feature1.internal.di.createFeature1Modules
import com.onthecrow.feature1.internal.presentation.Feature1Feature
import kotlinx.serialization.Serializable

class Feature1Component(
    componentContext: ComponentContext,
    dependencies: Feature1Dependencies,
) : Feature1, ComponentContext by componentContext {

    private val koinContext = instanceKeeper.getOrCreate {
        ComponentKoinContext()
    }

    private val scope = koinContext.getOrCreateKoinScope(
        createFeature1Modules(dependencies)
    )

    private val navigation = StackNavigation<Feature1Config>()

    override val childStack: Value<ChildStack<*, Feature1.Child>> = childStack(
        source = navigation,
        serializer = Feature1Config.serializer(),
        handleBackButton = true,
        initialStack = { listOf(Feature1Config.FirstScreenConfig) },
        childFactory = { config, _ -> child(config) },
    )

    override fun onNextClick() {
        navigation.bringToFront(Feature1Config.SecondScreenConfig)
    }

    override fun onBackPressed() {
        navigation.pop()
    }

    private fun child(
        config: Feature1Config,
    ): Feature1.Child {
        return when (config) {
            is Feature1Config.FirstScreenConfig -> {
                Feature1.Child.FirstChild(this)
            }

            is Feature1Config.SecondScreenConfig -> {
                Feature1.Child.SecondChild(this)
            }
        }
    }

    private val feature: Feature1Feature = instanceKeeper.getOrCreate { scope.get() }

    override val state: AnyStateFlow<Feature1UiState> = feature.state

    @Serializable
    private sealed interface Feature1Config {

        @Serializable
        data object FirstScreenConfig : Feature1Config

        @Serializable
        data object SecondScreenConfig : Feature1Config
    }
}