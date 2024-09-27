package com.onthecrow.feature5.internal.di

import com.onthecrow.feature5.api.Feature5Dependencies
import org.koin.core.module.Module

internal fun createFeature5Modules(dependencies: Feature5Dependencies): List<Module> {
    return listOf(
        feature5Module,
    )
}