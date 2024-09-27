package com.onthecrow.kmparchsample.di

import com.onthecrow.feature1.api.Feature1Dependencies
import com.onthecrow.feature2.api.Feature2Dependencies
import com.onthecrow.feature3.api.Feature3Dependencies
import com.onthecrow.feature4.api.Feature4Dependencies
import com.onthecrow.feature5.api.Feature5Dependencies
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

internal val rootModule = module {
    singleOf(::DefaultFeature1Dependencies) bind Feature1Dependencies::class
    singleOf(::DefaultFeature2Dependencies) bind Feature2Dependencies::class
    singleOf(::DefaultFeature3Dependencies) bind Feature3Dependencies::class
    singleOf(::DefaultFeature4Dependencies) bind Feature4Dependencies::class
    singleOf(::DefaultFeature5Dependencies) bind Feature5Dependencies::class
}

private class DefaultFeature1Dependencies : Feature1Dependencies
private class DefaultFeature2Dependencies : Feature2Dependencies
private class DefaultFeature3Dependencies : Feature3Dependencies
private class DefaultFeature4Dependencies : Feature4Dependencies
private class DefaultFeature5Dependencies : Feature5Dependencies