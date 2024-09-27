package com.onthecrow.feature2.internal.di

import com.onthecrow.feature2.api.Feature2Dependencies
import org.koin.core.module.Module

internal fun createFeature2Modules(dependencies: Feature2Dependencies): List<Module> {
    return listOf(
        feature2Module,
    )
}