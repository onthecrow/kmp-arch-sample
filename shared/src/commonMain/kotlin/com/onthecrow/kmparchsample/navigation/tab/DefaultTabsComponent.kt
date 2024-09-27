package com.onthecrow.kmparchsample.navigation.tab

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.onthecrow.feature1.api.Feature1Component
import com.onthecrow.feature2.api.Feature2Component
import com.onthecrow.feature3.api.Feature3Component
import kotlinx.serialization.Serializable
import org.koin.core.scope.Scope

internal class DefaultTabsComponent(
    componentContext: ComponentContext,
    private val scope: Scope,
) : TabsComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<TabConfig>()

    override val stack: Value<ChildStack<*, TabsComponent.Child>> =
        childStack(
            source = navigation,
            serializer = TabConfig.serializer(),
            initialConfiguration = TabConfig.Feature1,
            childFactory = ::child,
        )

    private fun child(tabConfig: TabConfig, componentContext: ComponentContext): TabsComponent.Child =
        when (tabConfig) {
            is TabConfig.Feature1 -> TabsComponent.Child.Feature1Child(
                    Feature1Component(
                        componentContext,
                        scope.get(),
                    )
                )
            is TabConfig.Feature2 -> TabsComponent.Child.Feature2Child(
                Feature2Component(
                    componentContext,
                    scope.get(),
                )
            )
            is TabConfig.Feature3 -> TabsComponent.Child.Feature3Child(
                Feature3Component(
                    componentContext,
                    scope.get(),
                )
            )
        }

    override fun onFeature1TabClicked() {
        navigation.bringToFront(TabConfig.Feature1)
    }

    override fun onFeature2TabClicked() {
        navigation.bringToFront(TabConfig.Feature2)
    }

    override fun onFeature3TabClicked() {
        navigation.bringToFront(TabConfig.Feature3)
    }

    @Serializable
    private sealed interface TabConfig {
        @Serializable
        data object Feature1 : TabConfig

        @Serializable
        data object Feature2 : TabConfig

        @Serializable
        data object Feature3 : TabConfig
    }
}