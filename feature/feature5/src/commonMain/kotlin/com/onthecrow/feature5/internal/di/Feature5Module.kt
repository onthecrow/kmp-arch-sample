package com.onthecrow.feature5.internal.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import com.onthecrow.feature5.internal.presentation.Feature5Feature
import com.onthecrow.feature5.internal.data.Feature5Repository

internal val feature5Module = module {
    factoryOf(::Feature5Feature)
    factoryOf(::Feature5Repository)
}