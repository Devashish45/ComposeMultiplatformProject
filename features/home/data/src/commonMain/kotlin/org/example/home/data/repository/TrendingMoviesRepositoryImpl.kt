package org.example.home.data.repository

import org.example.coreNetwork.apiService.ApiService
import org.example.home.data.mappers.toDomain
import org.example.home.domain.model.TrendingMovieResponseDomain
import org.example.home.domain.repository.TrendingMoviesRepository

class TrendingMoviesRepositoryImpl(
    private val apiService: ApiService
) : TrendingMoviesRepository {
    override suspend fun getTrendingMovies(): Result<TrendingMovieResponseDomain> {
        val result = apiService.getTrendingMovies()
        return if (result.isSuccess) {
            Result.success(result.getOrThrow().toDomain())
        } else {
            Result.failure(result.exceptionOrNull() ?: Exception("Unknown error"))
        }
    }
}