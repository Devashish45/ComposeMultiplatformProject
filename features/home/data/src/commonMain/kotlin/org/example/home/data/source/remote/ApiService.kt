//package org.example.home.data.source.remote
//
//import io.ktor.client.HttpClient
//import io.ktor.client.call.body
//import io.ktor.client.request.get
//import org.example.home.data.model.remote.TrendingMovieDto
//
//class ApiService(val httpClient: HttpClient) {
//    val BASE_URL = "https://api.rawg.io/api"
//    val API_KEY = "f8f3ab3d34d55edc30478ef0a17243e4"
//
//    //https://api.themoviedb.org/3/trending/movie/day?language=en-US
//    suspend fun getTrendingMovies(page:Int = 1): Result<TrendingMovieDto> {
//        return try {
//            val response = httpClient.get("3/movie/now_playing?&page=${page}")
//                .body<TrendingMovieDto>()
//            Result.success(response)
//        } catch (e: Exception) {
//            Result.failure(e)
//        }
//    }
//}