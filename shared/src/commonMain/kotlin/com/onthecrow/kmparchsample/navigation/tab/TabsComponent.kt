package com.onthecrow.kmparchsample.navigation.tab

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.onthecrow.feature1.api.Feature1Component
import com.onthecrow.feature2.api.Feature2Component
import com.onthecrow.feature3.api.Feature3Component

interface TabsComponent {

    val stack: Value<ChildStack<*, Child>>

    fun onFeature1TabClicked()
    fun onFeature2TabClicked()
    fun onFeature3TabClicked()

    sealed class Child {
        class Feature1Child(val component: Feature1Component) : Child()
        class Feature2Child(val component: Feature2Component) : Child()
        class Feature3Child(val component: Feature3Component) : Child()
    }
}