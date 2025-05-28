package org.example.coreNetwork.apiService

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.example.coreNetwork.model.TrendingMovieResponse

class ApiService(val httpClient: HttpClient) {
    val BASE_URL = "https://api.rawg.io/api"
    val API_KEY = "f8f3ab3d34d55edc30478ef0a17243e4"
    //https://api.themoviedb.org/3/trending/movie/day?language=en-US
    suspend fun getTrendingMovies(): Result<TrendingMovieResponse> {
        return try {
            val response = httpClient.get("3/trending/movie/day") {
                url {
                    parameter("api_key", API_KEY)
                    parameter("language", "en-US")
                }
            }.body<TrendingMovieResponse>()
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}