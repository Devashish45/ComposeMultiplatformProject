//package org.example.home.data.di
//
//
//import org.example.coreNetwork.client.KtorClientMovieDB
//import org.example.home.data.source.remote.ApiService
//import org.koin.dsl.module
//
//fun getHomeApiServiceModule() = module {
//    single { ApiService(httpClient = KtorClientMovieDB.getInstance()) }
//}