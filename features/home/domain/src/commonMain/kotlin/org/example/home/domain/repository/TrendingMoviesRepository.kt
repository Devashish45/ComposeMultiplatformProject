package org.example.home.domain.repository

import org.example.home.domain.model.TrendingMovieResponseDomain

interface TrendingMoviesRepository {

    suspend fun getTrendingMovies(): Result<TrendingMovieResponseDomain>
}