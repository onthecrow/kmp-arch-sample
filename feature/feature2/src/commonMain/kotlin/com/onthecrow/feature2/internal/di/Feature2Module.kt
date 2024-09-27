package com.onthecrow.feature2.internal.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import com.onthecrow.feature2.internal.presentation.Feature2Feature
import com.onthecrow.feature2.internal.data.Feature2Repository

internal val feature2Module = module {
    factoryOf(::Feature2Feature)
    factoryOf(::Feature2Repository)
}