package org.example.home.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import org.example.home.domain.model.TrendingMovies
import org.example.home.domain.useCases.GetTrendingMoviesUseCase

class TrendingMoviesViewModel(
    private val getTrendingMoviesUseCase: GetTrendingMoviesUseCase

) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreen.UiState())
    val uiState = _uiState.asStateFlow()

    init {
        getTrendingMovies()
    }

    private fun getTrendingMovies() = getTrendingMoviesUseCase.invoke()
        .onStart { _uiState.update { HomeScreen.UiState(isLoading = true) } }
        .onEach { result ->
            result.onSuccess { data ->
                _uiState.update {
                    HomeScreen.UiState(
                        trendingMovies = data.results
                    )
                }
            }.onFailure { error ->
                _uiState.update { HomeScreen.UiState(error = error.message.toString()) }
            }
        }.launchIn(viewModelScope)
}


object HomeScreen {
    data class UiState(
        val isLoading: Boolean = false,
        val trendingMovies: List<TrendingMovies.Result> = emptyList(),
        val error: String = ""

    )
}