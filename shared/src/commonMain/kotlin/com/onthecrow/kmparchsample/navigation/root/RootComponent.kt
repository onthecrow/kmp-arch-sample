package com.onthecrow.kmparchsample.navigation.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.slot.SlotNavigation
import com.arkivanov.decompose.router.slot.activate
import com.arkivanov.decompose.router.slot.childSlot
import com.arkivanov.decompose.router.slot.dismiss
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.onthecrow.coredi.ComponentKoinContext
import com.onthecrow.feature4.api.Feature4Component
import com.onthecrow.feature5.api.Feature5Component
import com.onthecrow.kmparchsample.di.rootModule
import com.onthecrow.kmparchsample.navigation.tab.DefaultTabsComponent
import kotlinx.serialization.Serializable

class RootComponent(
    componentContext: ComponentContext
) : Root, ComponentContext by componentContext {
    private val koinContext = instanceKeeper.getOrCreate {
        ComponentKoinContext()
    }

    private val scope = koinContext.getOrCreateKoinScope(
        listOf(rootModule)
    )

    private val navigation = StackNavigation<RootConfig>()

    override val childStack: Value<ChildStack<*, Root.Child>> = childStack(
        source = navigation,
        serializer = RootConfig.serializer(),
        handleBackButton = true,
        initialStack = { listOf(RootConfig.TabsConfig) },
        childFactory = ::child,
    )

    private val slotNavigation = SlotNavigation<SlotConfig>()

    override val childSlot: Value<ChildSlot<*, Root.SlotChild>> = childSlot(
        source = slotNavigation,
        serializer = SlotConfig.serializer(),
        handleBackButton = true,
        childFactory = ::child
    )

    override fun dismissSlotChild() {
        slotNavigation.dismiss()
    }

    override fun onBackClicked() {
        navigation.pop()
    }

    override fun onSettingsClick() {
        slotNavigation.activate(SlotConfig.BottomSheetConfig)
    }

    override fun onEditClick() {
        navigation.bringToFront(RootConfig.FullscreenConfig)
    }

    private fun child(
        config: RootConfig,
        componentContext: ComponentContext
    ): Root.Child {
        return when (config) {
            is RootConfig.TabsConfig -> {
                Root.Child.TabsChild(
                    DefaultTabsComponent(
                        componentContext = componentContext,
                        scope = scope,
                    )
                )
            }
            is RootConfig.FullscreenConfig -> {
                Root.Child.FullScreenChild(
                    Feature5Component(
                        dependencies = scope.get(),
                        componentContext = componentContext,
                        onDismiss = slotNavigation::dismiss
                    )
                )
            }
        }
    }

    private fun child(
        config: SlotConfig,
        componentContext: ComponentContext
    ): Root.SlotChild {
        return when (config) {
            is SlotConfig.BottomSheetConfig -> {
                Root.SlotChild.Feature4Child(
                    Feature4Component(
                        componentContext = componentContext,
                        dependencies = scope.get()
                    )
                )
            }
        }
    }

    @Serializable
    private sealed interface RootConfig {
        @Serializable
        data object TabsConfig : RootConfig

        @Serializable
        data object FullscreenConfig : RootConfig
    }

    @Serializable
    private sealed interface SlotConfig {
        @Serializable
        data object BottomSheetConfig : SlotConfig
    }
}