package org.example.project.di

import org.example.coreNetwork.di.getCoreNetworkModule
import org.example.home.data.di.getTrendingMoviesDataModule
import org.example.home.domain.di.getTrendingMoviesDomainModule
import org.example.home.ui.di.getTrendingMoviesUiModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(
            getCoreNetworkModule(),
            getTrendingMoviesDataModule(),
            getTrendingMoviesDomainModule(),
            getTrendingMoviesUiModule()
        )
    }
}