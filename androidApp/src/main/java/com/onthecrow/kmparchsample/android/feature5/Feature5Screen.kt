package com.onthecrow.kmparchsample.android.feature5

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.onthecrow.feature5.api.Feature5Component
import com.onthecrow.feature5.api.data.Feature5UiState

@Composable
fun Feature5Screen(
    component: Feature5Component,
    modifier: Modifier = Modifier,
) {
    val state = component.state.collectAsState()
    Text(
        modifier = modifier.wrapContentHeight(align = Alignment.CenterVertically),
        text = (state.value as? Feature5UiState.Data)?.feature5Data?.title ?: "",
        textAlign = TextAlign.Center,
    )
}