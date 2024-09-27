package com.onthecrow.feature1.internal.di

import com.onthecrow.feature1.api.Feature1Dependencies
import org.koin.core.module.Module

internal fun createFeature1Modules(dependencies: Feature1Dependencies): List<Module> {
    return listOf(
        feature1Module,
    )
}