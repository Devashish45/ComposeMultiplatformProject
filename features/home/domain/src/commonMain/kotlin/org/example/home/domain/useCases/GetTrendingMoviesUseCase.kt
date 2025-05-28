package org.example.home.domain.useCases


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import org.example.home.domain.repository.TrendingMoviesRepository

class GetTrendingMoviesUseCase(private val trendingMoviesRepository: TrendingMoviesRepository) {
    operator fun invoke() = flow {
        emit(trendingMoviesRepository.getTrendingMovies())
    }.catch { error -> emit(Result.failure(error)) }.flowOn(Dispatchers.IO)
}