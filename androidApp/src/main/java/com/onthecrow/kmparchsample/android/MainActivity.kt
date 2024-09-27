package com.onthecrow.kmparchsample.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.onthecrow.kmparchsample.android.common.AppBarInternal
import com.onthecrow.kmparchsample.android.common.rememberSlotModalBottomSheetState
import com.onthecrow.kmparchsample.android.feature4.Feature4Screen
import com.onthecrow.kmparchsample.android.feature5.Feature5Screen
import com.onthecrow.kmparchsample.android.tabs.TabsContent
import com.onthecrow.kmparchsample.navigation.root.Root
import com.onthecrow.kmparchsample.navigation.root.RootComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = RootComponent(defaultComponentContext())
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RootScreen(root)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RootScreen(
    root: Root,
    modifier: Modifier = Modifier
) {
    val bottomSheetState = rememberSlotModalBottomSheetState(
        root.childSlot,
        onDismiss = root::dismissSlotChild
    ) { slotChild ->
        when (val child = slotChild.instance) {
            is Root.SlotChild.Feature4Child -> Feature4Screen(
                component = child.component,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            )
        }
    }

    val state = root.childStack.subscribeAsState()

    Column(modifier) {
        AppBarInternal(
            canNavigateBack = state.value.active.instance is Root.Child.FullScreenChild,
            onSettingsClick = { root.onSettingsClick() },
            onEditClick = { root.onEditClick() },
            onBackClick = { root.onBackClicked() }
        )
        Children(
            stack = state.value,
            animation = stackAnimation(fade()),
            modifier = Modifier.fillMaxSize(),
        ) {
            when (val child = it.instance) {
                is Root.Child.FullScreenChild -> {
                    Feature5Screen(
                        child.component,
                        modifier = Modifier.fillMaxSize(),
                    )
                }

                is Root.Child.TabsChild -> {
                    TabsContent(
                        child.component,
                        modifier = Modifier.fillMaxSize(),
                    )
                }
            }
        }
    }

    val bottomSheetSlot = root.childSlot.subscribeAsState()
    bottomSheetSlot.value.child?.instance?.also {
        ModalBottomSheet(
            sheetState = bottomSheetState.sheetState,
            onDismissRequest = root::dismissSlotChild,
            content = bottomSheetState.sheetContent.value,
            dragHandle = null,
        )
    }
}