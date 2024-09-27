package com.onthecrow.feature4.internal.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import com.onthecrow.feature4.internal.presentation.Feature4Feature
import com.onthecrow.feature4.internal.data.Feature4Repository

internal val feature4Module = module {
    factoryOf(::Feature4Feature)
    factoryOf(::Feature4Repository)
}