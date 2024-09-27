package com.onthecrow.kmparchsample.android.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.onthecrow.kmparchsample.android.feature1.Feature1Content
import com.onthecrow.kmparchsample.android.feature2.Feature2Screen
import com.onthecrow.kmparchsample.android.feature3.Feature3Screen
import com.onthecrow.kmparchsample.navigation.tab.TabsComponent


@Composable
fun TabsContent(
    component: TabsComponent,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Children(
            component = component,
            modifier = Modifier
                .weight(1F)
                .consumeWindowInsets(WindowInsets.navigationBars),
        )
        BottomBar(component = component, modifier = Modifier.fillMaxWidth())
    }
}

@Composable
private fun Children(component: TabsComponent, modifier: Modifier = Modifier) {
    Children(
        stack = component.stack,
        modifier = modifier,
        animation = stackAnimation(fade()),
    ) {
        when (val child = it.instance) {
            is TabsComponent.Child.Feature1Child -> Feature1Content(
                component = child.component,
                modifier = Modifier.fillMaxSize()
            )

            is TabsComponent.Child.Feature2Child -> Feature2Screen(
                component = child.component,
                modifier = Modifier.fillMaxSize()
            )

            is TabsComponent.Child.Feature3Child -> Feature3Screen(
                component = child.component,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
private fun BottomBar(component: TabsComponent, modifier: Modifier = Modifier) {
    val stack by component.stack.subscribeAsState()
    val activeComponent = stack.active.instance

    NavigationBar(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceContainer)
            .navigationBarsPadding(),
    ) {
        NavigationBarItem(
            selected = activeComponent is TabsComponent.Child.Feature1Child,
            onClick = component::onFeature1TabClicked,
            icon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = ""
                )
            },
        )
        NavigationBarItem(
            selected = activeComponent is TabsComponent.Child.Feature2Child,
            onClick = component::onFeature2TabClicked,
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = ""
                )
            }
        )
        NavigationBarItem(
            selected = activeComponent is TabsComponent.Child.Feature3Child,
            onClick = component::onFeature3TabClicked,
            icon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = ""
                )
            }
        )
    }
}