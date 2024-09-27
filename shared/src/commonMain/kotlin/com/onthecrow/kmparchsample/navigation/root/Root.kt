package com.onthecrow.kmparchsample.navigation.root

import com.arkivanov.decompose.router.slot.ChildSlot
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.onthecrow.feature4.api.Feature4Component
import com.onthecrow.feature5.api.Feature5Component
import com.onthecrow.kmparchsample.navigation.tab.TabsComponent

interface Root {
    val childStack: Value<ChildStack<*, Child>>

    val childSlot: Value<ChildSlot<*, SlotChild>>

    fun dismissSlotChild()

    fun onSettingsClick()

    fun onEditClick()

    sealed class SlotChild {
        class Feature4Child(val component: Feature4Component) : SlotChild()
    }

    fun onBackClicked()

    sealed class Child {
        class TabsChild(val component: TabsComponent) : Child()
        class FullScreenChild(val component: Feature5Component) : Child()
    }
}