package org.example.home.ui.di

import org.example.home.domain.useCases.GetTrendingMoviesUseCase
import org.example.home.ui.home.TrendingMoviesViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun getTrendingMoviesUiModule() = module {
    viewModel { TrendingMoviesViewModel(getTrendingMoviesUseCase = get()) }
}