package com.onthecrow.feature3.internal.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import com.onthecrow.feature3.internal.presentation.Feature3Feature
import com.onthecrow.feature3.internal.data.Feature3Repository

internal val feature3Module = module {
    factoryOf(::Feature3Feature)
    factoryOf(::Feature3Repository)
}