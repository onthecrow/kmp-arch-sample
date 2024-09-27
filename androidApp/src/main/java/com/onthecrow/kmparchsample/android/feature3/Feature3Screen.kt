package com.onthecrow.kmparchsample.android.feature3

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.onthecrow.feature3.api.Feature3Component
import com.onthecrow.feature3.api.data.Feature3UiState

@Composable
fun Feature3Screen(
    component: Feature3Component,
    modifier: Modifier = Modifier,
) {
    val state = component.state.collectAsState()
    Text(
        modifier = modifier.wrapContentHeight(align = Alignment.CenterVertically),
        text = (state.value as? Feature3UiState.Data)?.feature3Data?.title ?: "",
        textAlign = TextAlign.Center,
    )
}