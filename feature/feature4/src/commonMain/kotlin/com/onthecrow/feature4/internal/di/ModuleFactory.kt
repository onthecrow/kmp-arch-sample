package com.onthecrow.feature4.internal.di

import com.onthecrow.feature4.api.Feature4Dependencies
import org.koin.core.module.Module

internal fun createFeature4Modules(dependencies: Feature4Dependencies): List<Module> {
    return listOf(
        feature4Module,
    )
}