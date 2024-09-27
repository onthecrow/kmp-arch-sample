package com.onthecrow.feature1.internal.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import com.onthecrow.feature1.internal.presentation.Feature1Feature
import com.onthecrow.feature1.internal.data.Feature1Repository

internal val feature1Module = module {
    factoryOf(::Feature1Feature)
    factoryOf(::Feature1Repository)
}