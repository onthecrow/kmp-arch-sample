package com.onthecrow.kmparchsample.android.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarInternal(
    canNavigateBack: Boolean,
    onEditClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = { Text("KMP Arch Sample") },
        actions = {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .clickable { onSettingsClick() }
            ) {
                Icon(
                    rememberVectorPainter(Icons.Default.Settings),
                    "",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .clickable { onEditClick() }
            ) {
                Icon(
                    rememberVectorPainter(Icons.Default.Create),
                    "",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        },
        navigationIcon = {
            if (canNavigateBack) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .aspectRatio(1f)
                        .clickable { onBackClick() }
                ) {
                    @Suppress("DEPRECATION")
                    Icon(
                        rememberVectorPainter(Icons.Default.ArrowBack),
                        "",
                        modifier = Modifier.align(Alignment.Center),
                    )
                }
            }
        },
    )
}