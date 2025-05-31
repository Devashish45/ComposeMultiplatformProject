package org.example.coreNetwork.client

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClientMovieDB {

    //https://api.themoviedb.org/3/trending/movie/day?language=en-US
    private const val HOST_MOVIE_DB = "api.themoviedb.org"
    fun getInstance(): HttpClient = HttpClient {

        install(ContentNegotiation) {
            json(json = Json {
                ignoreUnknownKeys = true
            })
        }
        install(DefaultRequest) {
            url {
                host = HOST_MOVIE_DB
                protocol = URLProtocol.HTTPS
                contentType(ContentType.Application.Json)
                accept(ContentType.Application.Json)
            }
        }

        install(HttpTimeout) {
            socketTimeoutMillis = 3000
            connectTimeoutMillis = 3000
            requestTimeoutMillis = 3000
        }

    }
}