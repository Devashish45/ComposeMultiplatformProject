package org.example.coreNetwork.di

import org.example.coreNetwork.apiService.ApiService
import org.example.coreNetwork.client.KtorClientMovieDB
import org.koin.dsl.module

fun provideMovieDbHttpClient() = module {
    single { ApiService(httpClient = KtorClientMovieDB.getInstance()) }
}