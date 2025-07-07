package org.example.home.domain.repository

import org.example.home.domain.model.TrendingMovies

interface TrendingMoviesRepository {

    suspend fun getTrendingMovies(): Result<TrendingMovies>
}