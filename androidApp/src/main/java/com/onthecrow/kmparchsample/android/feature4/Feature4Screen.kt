package com.onthecrow.kmparchsample.android.feature4

import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.onthecrow.feature4.api.Feature4Component
import com.onthecrow.feature4.api.data.Feature4UiState

@Composable
fun Feature4Screen(
    component: Feature4Component,
    modifier: Modifier = Modifier,
) {

    val componentState by component.state.collectAsState()

    when (val state = componentState) {
        is Feature4UiState.Data -> {
            Text(
                modifier = modifier.wrapContentHeight(align = Alignment.CenterVertically),
                text = state.feature4Data.title,
                textAlign = TextAlign.Center,

            )
        }
        Feature4UiState.Error -> {}
        Feature4UiState.Loading -> {}
    }
}