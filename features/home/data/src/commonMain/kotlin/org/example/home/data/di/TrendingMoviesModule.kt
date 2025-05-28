package org.example.home.data.di

import org.example.home.data.repository.TrendingMoviesRepositoryImpl
import org.example.home.domain.repository.TrendingMoviesRepository
import org.koin.dsl.module

fun getTrendingMoviesDataModule() = module {
    factory<TrendingMoviesRepository> {
        TrendingMoviesRepositoryImpl(apiService = get())
    }
}