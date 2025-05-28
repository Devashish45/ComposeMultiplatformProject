package org.example.home.domain.di

import org.example.home.domain.useCases.GetTrendingMoviesUseCase
import org.koin.dsl.module

fun getTrendingMoviesDomainModule() = module {
    factory { GetTrendingMoviesUseCase(trendingMoviesRepository = get()) }
}