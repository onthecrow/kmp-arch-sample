package com.onthecrow.feature1.api

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.onthecrow.core.flow.AnyStateFlow
import com.onthecrow.feature1.api.data.Feature1UiState

interface Feature1 {
    val state: AnyStateFlow<Feature1UiState>
    val childStack: Value<ChildStack<*, Child>>

    fun onNextClick()
    fun onBackPressed()

    sealed class Child {
        class FirstChild(val component: Feature1Component) : Child()
        class SecondChild(val component: Feature1Component) : Child()
    }
}