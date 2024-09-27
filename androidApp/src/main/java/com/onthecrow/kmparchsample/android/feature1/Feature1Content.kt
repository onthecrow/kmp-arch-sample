package com.onthecrow.kmparchsample.android.feature1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import com.onthecrow.feature1.api.Feature1
import com.onthecrow.feature1.api.Feature1Component

@Composable
fun Feature1Content(
    component: Feature1Component,
    modifier: Modifier = Modifier,
) {

    val navigationState = component.childStack.subscribeAsState()

    Children(
        stack = navigationState.value,
        animation = stackAnimation(fade()),
        modifier = modifier,
    ) {
        when (it.instance) {
            is Feature1.Child.FirstChild -> FirstScreen(component::onNextClick, Modifier.fillMaxSize())
            is Feature1.Child.SecondChild -> SecondScreen(component::onBackPressed, Modifier.fillMaxSize())
        }
    }
}

@Composable
private fun FirstScreen(
    onNextButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically),
            text = "Feature 1: First screen",
            textAlign = TextAlign.Center,
        )
        Button(onClick = onNextButtonClick) {
            Text("forward")
        }
    }
}

@Composable
private fun SecondScreen(
    onPreviousButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier.wrapContentHeight(align = Alignment.CenterVertically),
            text = "Feature 1: Second screen",
            textAlign = TextAlign.Center,
        )
        Button(onClick = onPreviousButtonClick) {
            Text("backward")
        }
    }
}