package com.onthecrow.feature3.internal.di

import com.onthecrow.feature3.api.Feature3Dependencies
import org.koin.core.module.Module

internal fun createFeature3Modules(dependencies: Feature3Dependencies): List<Module> {
    return listOf(
        feature3Module,
    )
}