package com.onthecrow.kmparchsample.android.feature2

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.onthecrow.feature2.api.Feature2Component
import com.onthecrow.feature2.api.data.Feature2UiState

@Composable
fun Feature2Screen(
    component: Feature2Component,
    modifier: Modifier = Modifier,
) {
    val state = component.state.collectAsState()
    Text(
        modifier = modifier.wrapContentHeight(align = Alignment.CenterVertically),
        text = (state.value as? Feature2UiState.Data)?.feature2Data?.title ?: "",
        textAlign = TextAlign.Center,
    )
}